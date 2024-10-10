package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreInventoryManager {
    List<Vehicle> availableList;
    List<Vehicle> reservedList;

    public StoreInventoryManager() {
        availableList = new ArrayList<>();
        reservedList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        availableList.add(vehicle);
        System.out.println("New Vehicle (" + vehicle.getVehicleNo() + ") added to the inventory.");
    }

    public void removeVehicle(Vehicle vehicle) {
        availableList.remove(vehicle);
        System.out.println("Vehicle No - " + vehicle.getVehicleNo() + " removed from the inventory.");
    }

    public Vehicle getActiveVehicle() {
        if(!availableList.isEmpty())
            return availableList.get(0);
        return null;
    }
    public void setVehicleInactive(Vehicle vehicle) {
        vehicle.updateStatus(VehicleStatus.INACTIVE);
    }
    public void setVehicleActive(Vehicle vehicle, boolean returned) {
        vehicle.updateStatus(VehicleStatus.ACTIVE);
        if(returned) {
            reservedList.remove(vehicle);
            availableList.add(vehicle);
        }
    }
    public void setVehicleReserved(Vehicle vehicle) {
        availableList.remove(vehicle);
        reservedList.add(vehicle);
        vehicle.updateStatus(VehicleStatus.RESERVED);
        System.out.println("Vehicle - " + vehicle.getVehicleNo() + " Reserved");
    }
}
