package Booking.example.RoomBookingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepo repo;
    
    public List<Customer> getCustomer(){

        return repo.findAll();
    }
    
    public Customer getCustomerById(int cusId){

        return repo.findById(cusId).orElse(null);
    }

    public Customer addCustomer(Customer cus){

        return repo.save(cus);
    }


    public void updateCustomer(Customer cus){

        repo.save(cus);
    }


    public int deleteCustomer(int cusId){
        if(!repo.existsById(cusId)){
            return 0;
        }
        repo.deleteById(cusId);
        return 1;
    }
}
