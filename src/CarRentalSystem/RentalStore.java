package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore {
    static int nextId = 1;
    int id;
    String name;
    Location location;
    private final StoreInventoryManager storeManager;
    List<Reservation> reservation;

    public RentalStore(String name, Location location) {
        this.id = nextId++;
        this.name = name;
        this.location = location;
        this.storeManager = new StoreInventoryManager();
        this.reservation = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        storeManager.addVehicle(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        storeManager.removeVehicle(vehicle);
    }
    public void updateLocation(Location location) {
        this.location = location;
        System.out.println("Store location updated.");
    }
    public Vehicle getVehicle() {
        return storeManager.getActiveVehicle();
    }
    public Reservation createReservation(Vehicle vehicle, User user, Date bookingFrom, Date bookingTill, PaymentMode paymentMode) {
        Reservation reservation = new Reservation(user, vehicle, bookingFrom, bookingTill);
        reservation.confirmReservation(paymentMode);
        storeManager.setVehicleReserved(reservation.vehicle);
        this.reservation.add(reservation);
        return reservation;
    }
    public void pickVehicle(Reservation reservation, User user) {
        //do some check if the reservation is correct or not ?
        if(reservation.user==user) {
            reservation.pickVehicle();
        }
    }
    public void returnVehicle(Reservation reservation, User user, Vehicle vehicle) {
        if(reservation.user==user && reservation.vehicle==vehicle) {
            reservation.returnVehicle();
            storeManager.setVehicleActive(vehicle, true);
            System.out.println("Vehicle - " + vehicle.getVehicleNo() + " returned.");
        }
    }
    public void setVehicleInactive(Vehicle vehicle) {
        storeManager.setVehicleInactive(vehicle);
    }
    public void setVehicleActive(Vehicle vehicle) {
        storeManager.setVehicleActive(vehicle, false);
    }
}
