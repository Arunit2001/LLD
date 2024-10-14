package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    static int nextId = 1;
    final int id;
    String name;
    int capacity;
    List<Seat> seatList = new ArrayList<>();

    public Screen() {
        this.id = nextId++;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }
}
