package BookMyShow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    static int nextId = 1;
    final int id;
    final Movie movie;
    final Screen screen;
    int startTime;
    List<Integer> bookedSeatIds = new ArrayList<>();

    public Show(Movie movie, Screen screen) {
        this.id = nextId++;
        this.movie = movie;
        this.screen = screen;
    }
    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }
}
