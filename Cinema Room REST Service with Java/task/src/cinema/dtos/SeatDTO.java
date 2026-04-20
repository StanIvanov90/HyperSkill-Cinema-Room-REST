package cinema.dtos;


public class SeatDTO {
    private int row;
    private int column;
    private int price;


    public SeatDTO() {
    }

    public SeatDTO(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
