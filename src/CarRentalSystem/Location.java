package CarRentalSystem;

public class Location {
    String address;
    String landmark;
    int pincode;
    String city;
    String state;

    public Location(String address, String landmark, int pincode, String city, String state) {
        this.address = address;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    public Location(String address, int pincode, String city, String state) {
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }
}
