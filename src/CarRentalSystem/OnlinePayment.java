package CarRentalSystem;

public class OnlinePayment implements Payment {

    @Override
    public void pay(Bill bill) {
        //logic
        System.out.println("Bill paid online for amount - " + bill.amount);
    }
}
