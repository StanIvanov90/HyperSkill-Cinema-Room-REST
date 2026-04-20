package cinema.dtos;

import cinema.models.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DtoMapper {

    public SeatDTO toDTO(Seat seat, int price) {
        if(seat == null) {
            return null;
        }
        return new SeatDTO(seat.getRow(), seat.getColumn(), price);
    }

    public Seat toEntity(SeatDTO seatDTO) {
        if(seatDTO == null) {
            return null;
        }
        return new Seat(seatDTO.getRow(), seatDTO.getColumn());
    }

    public CinemaRoomDTO toCinemaRoomDTO(int rows, int columns, List<SeatDTO> seatDtos) {
        return new CinemaRoomDTO(rows, columns, seatDtos);
    }

    public TicketDTO toTicketDTO(UUID token, Seat seat, int price) {
        return new TicketDTO(token, toDTO(seat,price));
    }
}
