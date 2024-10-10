package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRentalManager {
    List<RentalStore> storeList;
    List<User> userList;

    public CarRentalManager() {
        this.storeList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public void addStore(RentalStore store) {
        storeList.add(store);
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public List<RentalStore> getStore(String city) {
        return storeList.stream()
                .filter(store -> Objects.equals(store.location.city, city))
                .collect(Collectors.toList());
    }
}
