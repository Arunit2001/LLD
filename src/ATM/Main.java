package ATM;

public class Main {
    public static void main(String[] args) throws Exception {
        User user1 = new User("A");
        BankAccount account1 = new BankAccount(user1,1500);
        user1.setAccount(account1);
        Card card1 = new Card("5879", account1);
        user1.setCard(card1);
        ATMMachine atm1 = new ATMMachine();
        ATMState state = atm1.getState();
        state.insertCard(atm1, card1);

        state = atm1.getState();
        state.authenticatePin(atm1, 2524);

        state = atm1.getState();
        state.selectOperation(atm1, ATMOperation.CASH_WITHDRAWL);

        state = atm1.getState();
        state.cashWithdrawl(atm1, 2000);

        state = atm1.getState();
        state.insertCard(atm1, card1);

        state = atm1.getState();
        state.authenticatePin(atm1, 2524);

        state = atm1.getState();
        state.selectOperation(atm1, ATMOperation.CHECK_BALANCE);

        state = atm1.getState();
        state.displayBalance(atm1);
    }
}
