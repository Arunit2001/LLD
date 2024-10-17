package ATM;

public class BankAccount {
    static int nextId = 1;
    final int id;
    double balance;
    final User user;

    public BankAccount(User user, double balance) {
        this.id = nextId++;
        this.user = user;
        this.balance = balance;
    }

    public BankAccount(User user) {
        this.id = nextId++;
        this.user = user;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
