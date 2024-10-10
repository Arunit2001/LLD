package CarRentalSystem;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RentalStore s1 = new RentalStore("Store1", new Location("xyz street", "near abc", 12345, "Bangalore", "Karnataka"));
        RentalStore s2 = new RentalStore("Store2", new Location("qwe street", "near asd", 56789, "Bangalore", "Karnataka"));
        User u1 = new User("Abc", "123456qwe");
        Vehicle car1 = new Car("123QWE", VehicleType.CAR);
        Vehicle car2 = new Car("234WER", VehicleType.CAR);
        Vehicle bike1 = new Bike("345ERT", VehicleType.BIKE);
        Vehicle bike2 = new Bike("456RTY", VehicleType.BIKE);
        s1.addVehicle(car1);
        s1.addVehicle(bike1);
        s2.addVehicle(car2);
        s2.addVehicle(bike2);
        CarRentalManager rentalManager = new CarRentalManager();
        rentalManager.addStore(s1);
        rentalManager.addStore(s2);
        rentalManager.addUser(u1);
        List<RentalStore> storeList = rentalManager.getStore("Bangalore");
        if(!storeList.isEmpty()){
            RentalStore store = storeList.get(0);
            Vehicle car = store.getVehicle();
            if(car!=null){
                Reservation r = store.createReservation(car, u1, new Date(), new Date(System.currentTimeMillis() + 86400 * 1000 * 2), PaymentMode.ONLINE);
                store.pickVehicle(r, u1);
                store.returnVehicle(r, u1, car);
            }
        }
    }
}
