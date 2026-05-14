package Booking.example.RoomBookingApp.Model;

import Booking.example.RoomBookingApp.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    BookingRepo repo;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) {
            Customer admin = new Customer();
            admin.setFirstname("Admin");
            admin.setLastname("1");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            admin.setDob(LocalDate.of(1990, 1, 1));
            repo.save(admin);
            System.out.println("Admin created: admin@gmail.com / admin123");

    }
}