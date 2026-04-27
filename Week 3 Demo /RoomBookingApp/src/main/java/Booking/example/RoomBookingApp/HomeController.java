package Booking.example.RoomBookingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    BookingService service;

    @GetMapping("/hi")
    public String getHi(){

        return "Hi all";
    }


    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        
        return service.getCustomer();
    }
    
    @GetMapping("/customers/{cusId}")
        public ResponseEntity<?> getCustomerById(@PathVariable int cusId){
        Customer cus2= service.getCustomerById(cusId);
        if(cus2 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer found");
        }
        return ResponseEntity.ok(cus2);
        }

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer cus){
        Customer cus1= service.addCustomer(cus);
        return new ResponseEntity<>(cus1, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer cus){

        service.updateCustomer(cus);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @DeleteMapping("/customers/{cusId}")
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
}
