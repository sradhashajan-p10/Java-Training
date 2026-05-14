package Booking.example.RoomBookingApp.Controller;

import Booking.example.RoomBookingApp.DTO.CustomerRequestDTO;
import Booking.example.RoomBookingApp.DTO.CustomerResponseDTO;
import Booking.example.RoomBookingApp.Service.BookingService;
import Booking.example.RoomBookingApp.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    BookingService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hi")
    public String getHi(){

        return "Hi all";
    }


    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerResponseDTO> getCustomer(){

         List<Customer> c= service.getCustomer();
         List<CustomerResponseDTO> c1= new ArrayList<>();
         for(Customer cus : c ){
              c1.add(EntitytoResponse(cus));
         }
         return c1;
    }
    
    @GetMapping("/customers/{cusId}")
    @PreAuthorize("hasRole('ADMIN') or principal.id == #cusId")
        public ResponseEntity<?> getCustomerById(@PathVariable int cusId){
        Customer cus2= service.getCustomerById(cusId);
        if(cus2 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer found");
        }
        CustomerResponseDTO c= EntitytoResponse(cus2);
        return ResponseEntity.ok(c);
        }

    @PostMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponseDTO> addCustomer(@Valid @RequestBody CustomerRequestDTO creq){
        Customer cus1= RequesttoEntity(creq);

        Customer cus= service.addCustomer(cus1);

        CustomerResponseDTO cres= EntitytoResponse(cus);

        return ResponseEntity.status(HttpStatus.CREATED).body(cres);
    }

    @PutMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody CustomerRequestDTO cres){
        Customer cus= RequesttoEntity(cres);

        service.updateCustomer(cus);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @PatchMapping("/customers/{cusId}")
    @PreAuthorize("hasRole('ADMIN') or principal.id == #cusId")
    public ResponseEntity<?> updateCustomerpartially (@PathVariable int cusId, @RequestBody CustomerRequestDTO creq ){
        Customer c1= service.getCustomerById(cusId);
        if(c1==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Customer Found");
        }

        if(creq.getFirstname()!= null) c1.setFirstname(creq.getFirstname());
        if(creq.getLastname()!= null) c1.setLastname(creq.getLastname());
        if(creq.getDob()!=null) c1.setDob(creq.getDob());
        if(creq.getEmail()!=null) c1.setEmail(creq.getEmail());
        if(creq.getPassword()!=null) {
            c1.setPassword(passwordEncoder.encode(creq.getPassword()));
            service.updateCustomer(c1);
            return ResponseEntity.ok("Password Updated Successfully");
        }


        service.updateCustomer(c1);
        CustomerResponseDTO c = EntitytoResponse(c1);

        return ResponseEntity.ok(c);

    }

    @DeleteMapping("/customers/{cusId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCustomer(@PathVariable int cusId) {
        int a= service.deleteCustomer(cusId);
        if (a==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No customer found");
        }
        else{
            return ResponseEntity.ok("Customer deleted successfully");
        }


    }

    public Customer RequesttoEntity (CustomerRequestDTO creq){
        Customer cus1= new Customer();
        cus1.setFirstname(creq.getFirstname());
        cus1.setLastname(creq.getLastname());
        cus1.setDob(creq.getDob());
        cus1.setEmail(creq.getEmail());
        cus1.setPassword(creq.getPassword());
        cus1.setRole("ROLE_" + creq.getRole());
        return cus1;
    }

    public CustomerResponseDTO EntitytoResponse (Customer cus){
        CustomerResponseDTO cres= new CustomerResponseDTO();
        cres.setId(cus.getId());
        cres.setFirstname(cus.getFirstname());
        cres.setLastname(cus.getLastname());
        cres.setDob(cus.getDob());
        cres.setEmail(cus.getEmail());
        return cres;
    }

}
