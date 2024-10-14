package BookMyShow;

public abstract class Seat {
    static int nextId = 1;
    final int id;
    int row;
    int col;
    SeatCategory seatType;
    double price;

    public Seat() {
        this.id = nextId++;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setSeatType(SeatCategory seatType) {
        this.seatType = seatType;
    }

    public abstract void setPrice(double price);

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SeatCategory getSeatType() {
        return seatType;
    }

    public double getPrice() {
        return price;
    }
}
