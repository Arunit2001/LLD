package ATM;

public interface ATMState {
    public void insertCard(ATMMachine machine, Card card) throws Exception;
    public void authenticatePin(ATMMachine machine, int pin) throws Exception;
    public void selectOperation(ATMMachine machine, ATMOperation operation) throws Exception;
    public void cashWithdrawl(ATMMachine machine, double amount) throws Exception;
    public void displayBalance(ATMMachine machine) throws Exception;
    public void changePin(ATMMachine machine) throws Exception;
    public void cancel(ATMMachine machine) throws Exception;
    public Card returnCard(ATMMachine machine) throws Exception;
    public void depositMoney(ATMMachine machine) throws Exception;
}
