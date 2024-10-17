package ATM;

public class CashWithdrawlState implements ATMState {
    public CashWithdrawlState() {
        System.out.println("ATM is in CashWithdrawal state.");
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
        double avlBal = machine.getCard().getAccount().getBalance();
        if(machine.getBalance() < amount) {
            System.out.println("Insufficient Amount in ATM.");
            cancel(machine);
            return;
        }
        if(amount > avlBal) {
            System.out.println("Insufficient Balance.");
            cancel(machine);
        } else {
            // We can use Chain of Responsibility principle to handle cash withdrawal.
            machine.getCard().getAccount().setBalance(avlBal - amount);
            System.out.println("Collect your money from cash dispenser.");
            returnCard(machine);
        }
    }

    @Override
    public void displayBalance(ATMMachine machine) throws Exception {
        throw new Exception("Can't display balance while cash withdrawal.");
    }

    @Override
    public void changePin(ATMMachine machine) throws Exception {
        throw new Exception("Can't change pin while cash withdrawal.");
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
        throw new Exception("Can't deposit money while cash withdrawal.");
    }
}
