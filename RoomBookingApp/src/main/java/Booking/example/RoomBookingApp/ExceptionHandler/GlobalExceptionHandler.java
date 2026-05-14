package Booking.example.RoomBookingApp.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> argumemtNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        List<FieldError> err = ex.getBindingResult().getFieldErrors();
        for (FieldError e : err) {
            String ErrName = e.getField();
            String ErrMess = e.getDefaultMessage();
            errors.put(ErrName, ErrMess);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,String>> emailAlreadyExists (IllegalArgumentException ex){
        Map<String,String> e1= new LinkedHashMap<>();
        e1.put("Error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e1);
    }

}