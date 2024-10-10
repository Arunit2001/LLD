package CarRentalSystem;

public enum ReservationStatus {
    CANCELLED,  // Reservation got cancelled for some reason.
    COMPLETED,  // Vehicle Returned.
    CONFIRMED,  // Payment Done.
    PENDING,    // Payment not done.
    PICKED      // Vehicle picked up.
}
