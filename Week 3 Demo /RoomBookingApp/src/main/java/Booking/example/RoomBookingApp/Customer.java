//package Booking.example.roomBookingApp;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jdk.jfr.DataAmount;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//@Component
//@Entity
//public class Customer {
//    @Id
//    int id;
//    String firstname;
//    String lastname;
//    LocalDate dob;
//    String email;
//    String password;
//}

package Booking.example.RoomBookingApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private int id;

    private String firstname;
    private String lastname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String email;
    private String password;


}