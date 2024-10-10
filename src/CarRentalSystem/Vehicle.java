package CarRentalSystem;

public class Vehicle {
    static int nextId = 1;
    int id;
    private final String vehicleNo;
    VehicleType type;
    VehicleStatus status;

    public Vehicle(String vehicleNo, VehicleType type) {
        this.id = nextId++;
        this.vehicleNo = vehicleNo;
        this.type = type;
        this.status = VehicleStatus.ACTIVE;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }
    public void updateStatus(VehicleStatus status) {
        this.status = status;
        System.out.println("Vehicle Status updated to: " + this.status.name());
    }
}
