package cinema.dtos;

import java.util.List;

public class CinemaRoomDTO {
    private int rows;
    private int columns;
    private List<SeatDTO> seats;

    public CinemaRoomDTO(int rows, int columns, List<SeatDTO> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public List<SeatDTO> getSeats() {
        return seats;
    }
}
