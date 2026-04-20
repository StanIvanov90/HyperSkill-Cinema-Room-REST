package cinema.controllers;

import cinema.dtos.ReturnRequestDTO;
import cinema.dtos.SeatDTO;
import cinema.dtos.TicketDTO;
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
        return ResponseEntity.ok(cinemaService.purchaseTicket(seatDTO));
    }

    @PostMapping("/return")
        public ResponseEntity<?> returnTicket(@RequestBody ReturnRequestDTO token){
        TicketDTO returnedSeat = cinemaService.returnTicket(token.getToken());
            return ResponseEntity.ok(Map.of("ticket", returnedSeat.getTicket()));
        }

        @GetMapping(value = "/stats")
        public ResponseEntity<?> getStatistics(@RequestParam String password) {
            return ResponseEntity.ok(cinemaService.getStatistics(password));
        }

    }


