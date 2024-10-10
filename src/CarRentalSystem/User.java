package CarRentalSystem;

import java.util.Stack;

public class User {
    static int nextId = 1;
    int id;
    String name;
    String license;
    Stack<String> reservationHistory = new Stack<>();

    public User(String name, String license) {
        this.id = nextId++;
        this.name = name;
        this.license = license;
    }

    public void pushHistory(String reservation) {
        reservationHistory.push(reservation);
    }
}
