package cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private static final int FIRST_ROWS = 4;
    private static final int EXPECTED_PRICE = 10;
    private static final int NORMAL_PRICE = 8;

    private int row;
    private int column;
    private int price;
    private boolean isReserved;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = (row <= FIRST_ROWS) ? EXPECTED_PRICE : NORMAL_PRICE;
        this.isReserved = false;
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

    @JsonIgnore
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }


}
