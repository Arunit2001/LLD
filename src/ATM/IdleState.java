package ATM;

public class IdleState implements ATMState {
    public IdleState() {
        System.out.println("ATM in Idle State.");
    }
    @Override
    public void insertCard(ATMMachine machine, Card card) throws Exception {
        machine.setCard(card);
        machine.setState(new HasCardState());
    }

    @Override
    public void authenticatePin(ATMMachine machine, int pin) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void selectOperation(ATMMachine machine, ATMOperation operation) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void cashWithdrawl(ATMMachine machine, double amount) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void displayBalance(ATMMachine machine) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void changePin(ATMMachine machine) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void cancel(ATMMachine machine) throws Exception {
        System.out.println("No Transaction to cancel.");
    }

    @Override
    public Card returnCard(ATMMachine machine) throws Exception {
        throw new Exception("Please insert card...");
    }

    @Override
    public void depositMoney(ATMMachine machine) throws Exception {
        throw new Exception("Please insert card...");
    }
}
