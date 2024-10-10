package CarRentalSystem;

public class CashPayment implements Payment {

    @Override
    public void pay(Bill bill) {
        //logic
        System.out.println("Bill paid by cash for amount - " + bill.amount);
    }
}
