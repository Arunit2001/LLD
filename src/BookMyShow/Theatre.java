package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    static int nextId = 1;
    final int id;
    final String name;
    final City city;
    List<Screen> screenList = new ArrayList<>();

    List<Show> showList = new ArrayList<>();

    public Theatre(String name, City city) {
        this.id = nextId++;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city.name();
    }
    public List<Screen> getScreenList() {
        return screenList;
    }
    public List<Show> getShowList() {
        return showList;
    }
    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }
}
