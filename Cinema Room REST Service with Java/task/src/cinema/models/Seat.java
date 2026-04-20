package cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Seat {

    private static final int FIRST_ROWS = 4;
    private static final int EXPECTED_PRICE = 10;
    private static final int NORMAL_PRICE = 8;

    private int row;
    private int column;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Seat seat)) return false;
        return getRow() == seat.getRow() && getColumn() == seat.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }
}
