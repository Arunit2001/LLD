package ATM;

public class Card {
    final String cardNo;
    final BankAccount account;
    private int pin;
    public Card(String cardNo, BankAccount account) {
        this.cardNo = cardNo;
        this.account = account;
        this.pin = 2524;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public BankAccount getAccount() {
        return account;
    }
}
