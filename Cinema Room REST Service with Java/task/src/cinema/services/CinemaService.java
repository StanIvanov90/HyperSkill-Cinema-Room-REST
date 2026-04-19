package cinema.services;

import cinema.models.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    private final CinemaRoom cinemaRoom;

    @Autowired
    public CinemaService(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }
}
