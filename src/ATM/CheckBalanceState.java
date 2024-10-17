package ATM;

public class CheckBalanceState implements ATMState {
    public CheckBalanceState() {
        System.out.println("ATM in Check balance state.");
    }
    @Override
    public void insertCard(ATMMachine machine, Card card) throws Exception {
        throw new Exception("Card already inserted.");
    }

    @Override
    public void authenticatePin(ATMMachine machine, int pin) throws Exception {
        throw new Exception("PIN already authenticated.");
    }

    @Override
    public void selectOperation(ATMMachine machine, ATMOperation operation) throws Exception {
        throw new Exception("Select Operation not allowed in this state. Restart again");
    }

    @Override
    public void cashWithdrawl(ATMMachine machine, double amount) throws Exception {
        throw new Exception("Cash withdrawal not allowed in this state. Restart again");
    }

    @Override
    public void displayBalance(ATMMachine machine) throws Exception {
        double avlBal = machine.getCard().getAccount().getBalance();
        System.out.println("Your Current Balance is : " + avlBal);
        returnCard(machine);
    }

    @Override
    public void changePin(ATMMachine machine) throws Exception {
        throw new Exception("PIN change not allowed in this state. Restart again.");
    }

    @Override
    public void cancel(ATMMachine machine) throws Exception {
        System.out.println("Cancelling transaction.");
        returnCard(machine);
    }

    @Override
    public Card returnCard(ATMMachine machine) throws Exception {
        Card card = machine.getCard();
        machine.setCard(null);
        machine.setState(new IdleState());
        System.out.println("Please collect your card");
        return card;
    }

    @Override
    public void depositMoney(ATMMachine machine) throws Exception {
        throw new Exception("Deposit money not allowed in this state. Restart again.");
    }
}
