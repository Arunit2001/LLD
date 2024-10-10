package CarRentalSystem;

import java.util.Date;

public class Reservation {
    static int nextId = 1;
    int id;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookedFrom;
    Date bookedTill;
    ReservationStatus status;
    Bill bill;

    public Reservation(User user, Vehicle vehicle, Date bookedFrom, Date bookedTill) {
        this.id = nextId++;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = new Date();
        this.bookedFrom = bookedFrom;
        this.bookedTill = bookedTill;
        this.status = ReservationStatus.PENDING;
    }
    public void updateBookingSlot(Date bookedFrom, Date bookedTill) {
        this.bookedFrom = bookedFrom;
        this.bookedTill = bookedTill;
        System.out.println("Booking Date updated.");
    }
    public void confirmReservation(PaymentMode paymentMode) {
        //Bill Payment
        this.bill = new Bill(this);
        this.status = ReservationStatus.CONFIRMED;
        bill.payBill(paymentMode);
    }
    public void cancelReservation() {
        this.status = ReservationStatus.CANCELLED;
        System.out.println("Reservation Cancelled.");
    }
    public void pickVehicle() {
        this.status = ReservationStatus.PICKED;
        System.out.println("Vehicle - " + vehicle.getVehicleNo() + " picked up.");
    }
    public void returnVehicle() {
        this.status = ReservationStatus.COMPLETED;
    }
}
