package cinema.services;

import cinema.dtos.CinemaRoomDTO;
import cinema.dtos.DtoMapper;
import cinema.dtos.SeatDTO;
import cinema.dtos.TicketDTO;
import cinema.exceptions.DuplicateEntityException;
import cinema.exceptions.EntityOutOfBoundsException;
import cinema.exceptions.WrongEntityException;
import cinema.models.CinemaRoom;
import cinema.models.Seat;
import cinema.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaService {

    private static final int MIN_ROW = 1;
    private static final int MIN_COLUMN = 1;
    private static final String ALREADY_PURCHASED_ERROR_MESSAGE = "The ticket has been already purchased!";
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "The number of a row or a column is out of bounds!";
    private static final String WRONG_TOKEN_ERROR_MESSAGE = "Wrong token!";
    private static final int FIRST_ROWS = 4;
    private static final int EXPENSIVE_PRICE = 10;
    private static final int NORMAL_PRICE = 8;

    private final CinemaRoom cinemaRoom;
    private final CinemaRepository cinemaRepository;
    private final DtoMapper dtoMapper;

    @Autowired
    public CinemaService(CinemaRoom cinemaRoom, CinemaRepository cinemaRepository, DtoMapper dtoMapper) {
        this.cinemaRoom = cinemaRoom;
        this.cinemaRepository = cinemaRepository;
        this.dtoMapper = dtoMapper;
    }

    public CinemaRoomDTO getCinemaRoomDTO() {
        List<SeatDTO> seatDtos = cinemaRoom.getSeats().stream()
                .map(seat -> dtoMapper.toDTO(seat, calculatePrice(seat)))
                .toList();

        return dtoMapper.toCinemaRoomDTO(cinemaRoom.getRows(), cinemaRoom.getColumns(), seatDtos);
    }

    public synchronized TicketDTO purchaseTicket(SeatDTO seatDTO) {
        Seat seat = dtoMapper.toEntity(seatDTO);

        if (isOutOfBounds(seat)) {
            throw new EntityOutOfBoundsException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
        if (cinemaRepository.isSeatPurchased(seat)) {
            throw new DuplicateEntityException(ALREADY_PURCHASED_ERROR_MESSAGE);
        }

        UUID token = UUID.randomUUID();
        cinemaRepository.purchaseSeat(seat);
        cinemaRepository.purchaseTicket(token, seat);
        return dtoMapper.toTicketDTO(token, seat, calculatePrice(seat));

    }

    public synchronized TicketDTO returnTicket(UUID token) {
        if (!cinemaRepository.isTicketPurchased(token)) {
            throw new WrongEntityException(WRONG_TOKEN_ERROR_MESSAGE);
        }
        Seat seat = cinemaRepository.getTicket(token);
        cinemaRepository.removeSeat(seat);
        cinemaRepository.removeTicket(token);
        return dtoMapper.toTicketDTO(token, seat, calculatePrice(seat));
    }

    private boolean isOutOfBounds(Seat seat) {
        return seat.getRow() < MIN_ROW ||
                seat.getColumn() < MIN_COLUMN ||
                seat.getRow() > cinemaRoom.getRows() ||
                seat.getColumn() > cinemaRoom.getColumns();
    }

    private int calculatePrice(Seat seat) {
        return (seat.getRow() <= FIRST_ROWS) ? EXPENSIVE_PRICE : NORMAL_PRICE;
    }

}
