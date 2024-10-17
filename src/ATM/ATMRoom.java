package ATM;

import java.util.ArrayList;
import java.util.List;

public class ATMRoom {
    List<ATMMachine> atms;
    List<User> users;

    public ATMRoom() {
        this.atms = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<ATMMachine> getAtms() {
        return atms;
    }

    public void setAtms(List<ATMMachine> atms) {
        this.atms = atms;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
