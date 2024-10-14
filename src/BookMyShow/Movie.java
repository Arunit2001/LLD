package BookMyShow;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    static int nextId = 1;
    final int id;
    final String name;
    List<Theatre> theatreList;

    public Movie(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public void setTheatreList(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }
}
