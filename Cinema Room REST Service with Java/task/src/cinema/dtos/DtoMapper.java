package cinema.dtos;

import cinema.models.CinemaRoom;
import cinema.models.Seat;
import org.springframework.stereotype.Component;

import java.util.List;

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

}
