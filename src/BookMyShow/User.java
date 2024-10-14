package BookMyShow;

import java.util.ArrayList;
import java.util.Stack;

public class User {
    static int nextId = 1;
    final int id;
    final String name;
    Stack<Movie> history;

    // Constructor for final fields only.
    public User(String name) {
        this.id = nextId++;
        this.name = name;
        this.history = new Stack<>();
    }
    public void updateHistory(Movie movie) {
        history.push(movie);
    }
    public Stack<Movie> getHistory() {
        return history;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
