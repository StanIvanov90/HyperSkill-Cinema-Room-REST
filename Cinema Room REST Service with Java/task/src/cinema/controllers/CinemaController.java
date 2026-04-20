package cinema.controllers;

import cinema.dtos.SeatDTO;
import cinema.exceptions.DuplicateEntityException;
import cinema.exceptions.EntityOutOfBoundsException;
import cinema.services.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;


    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public ResponseEntity<?> getCinemaRoom() {
        return ResponseEntity.ok(cinemaService.getCinemaRoomDTO());
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> bookSeat(@RequestBody SeatDTO seatDTO) {
        try {
            return ResponseEntity.ok(cinemaService.bookSeat(seatDTO));
        } catch (EntityOutOfBoundsException | DuplicateEntityException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}


