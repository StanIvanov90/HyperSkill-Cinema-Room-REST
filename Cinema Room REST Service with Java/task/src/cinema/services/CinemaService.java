package cinema.services;

import cinema.models.CinemaRoom;
import cinema.models.Seat;
import cinema.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    private static final int MIN_ROW = 1;
    private static final int MIN_COLUMN = 1;
    private final CinemaRoom cinemaRoom;
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRoom cinemaRoom, CinemaRepository cinemaRepository) {
        this.cinemaRoom = cinemaRoom;
        this.cinemaRepository = cinemaRepository;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public Seat bookSeat(Seat seat) {
        if (isOutOfBounds(seat)) {
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
        if (cinemaRepository.isSeatPurchased(seat)) {
            throw new IllegalArgumentException("Seat is already purchased");
        }
        cinemaRepository.purchaseSeat(seat);
        return seat;
    }

    private boolean isOutOfBounds(Seat seat) {
        return seat.getRow() < MIN_ROW ||
                seat.getColumn() < MIN_COLUMN ||
                seat.getRow() > cinemaRoom.getRows() ||
                seat.getColumn() > cinemaRoom.getColumns();
    }
}
