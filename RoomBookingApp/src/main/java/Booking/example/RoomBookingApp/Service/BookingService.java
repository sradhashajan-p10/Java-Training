package Booking.example.RoomBookingApp.Service;

import Booking.example.RoomBookingApp.Repository.BookingRepo;
import Booking.example.RoomBookingApp.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BookingService {
    @Autowired
    BookingRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public List<Customer> getCustomer(){

        return repo.findAll();
    }
    
    public Customer getCustomerById(int cusId){

        return repo.findById(cusId).orElse(null);
    }

    public Customer addCustomer(Customer cus){
        if (repo.existsByEmail(cus.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        cus.setPassword(passwordEncoder.encode(cus.getPassword()));
        return repo.save(cus);
    }


    public void updateCustomer(Customer cus){
        if(repo.existsByEmail(cus.getEmail())){
            Customer cus1= repo.findByEmail(cus.getEmail()).get();
            cus1.setFirstname(cus.getFirstname());
            cus1.setLastname(cus.getLastname());
            cus1.setDob(cus.getDob());
            cus1.setEmail(cus.getEmail());
            cus1.setPassword(passwordEncoder.encode(cus.getPassword()));
            cus1.setRole(cus.getRole());
            repo.save(cus1);
        }
        else{
            cus.setPassword(passwordEncoder.encode(cus.getPassword()));
            repo.save(cus);
        }

    }


    public int deleteCustomer(int cusId){
        if(!repo.existsById(cusId)){
            return 0;
        }
        repo.deleteById(cusId);
        return 1;
    }

}
