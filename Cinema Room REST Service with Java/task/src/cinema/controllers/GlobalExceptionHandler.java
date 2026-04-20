package cinema.controllers;

import cinema.exceptions.DuplicateEntityException;
import cinema.exceptions.EntityOutOfBoundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityOutOfBoundsException.class, DuplicateEntityException.class})
    public ResponseEntity<Map<String, String>> handleBookingErrors(RuntimeException e) {
        return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    }

}
