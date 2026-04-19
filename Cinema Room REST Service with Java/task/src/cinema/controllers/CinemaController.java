package cinema.controllers;

import cinema.services.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;


    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public ResponseEntity<?> getCinemaRoom() {
            return ResponseEntity.ok(cinemaService.getCinemaRoom());
        }
    }


