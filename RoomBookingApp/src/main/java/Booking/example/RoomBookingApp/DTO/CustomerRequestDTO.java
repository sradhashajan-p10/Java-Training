package Booking.example.RoomBookingApp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank(message = "Firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "Lastname cannot be blank")
    private String lastname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email cant be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 10, message = "Password must be between 8 and 10 characters")
    private String password;
    @NotBlank(message = "Role cant be blank")
    @Pattern(
            regexp = "ADMIN|USER",
            message = "Role must be USER or ADMIN"
    )

    private String role;
}
