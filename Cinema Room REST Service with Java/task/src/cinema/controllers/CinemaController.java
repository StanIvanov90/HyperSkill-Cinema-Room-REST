package cinema.controllers;

import cinema.dtos.SeatDTO;
import cinema.exceptions.DuplicateEntityException;
import cinema.exceptions.EntityOutOfBoundsException;
import cinema.services.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(cinemaService.bookSeat(seatDTO));
    }


}


