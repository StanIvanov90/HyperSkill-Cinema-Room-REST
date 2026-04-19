package cinema.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CinemaRoom {
    private int rows;
    private int columns;
    private List<Seat> seats;

    public CinemaRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = new ArrayList<>(seats);
    }


}
