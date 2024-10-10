package CarRentalSystem;

public class Bill {
    Reservation reservation;
    int amount;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.amount = computeBill();
        isPaid = false;
    }
    private int computeBill() {
        //calculate bill according to reservation
        return 100;
    }
    public void payBill(PaymentMode paymentMode) {
        Payment payment = paymentMode==PaymentMode.ONLINE ? new OnlinePayment() : new CashPayment();
        payment.pay(this);
        isPaid = true;
    }
}
