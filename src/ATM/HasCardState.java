package ATM;

public class HasCardState implements ATMState {

    public HasCardState() {
        System.out.println("ATM is in HasCardState.");
    }

    @Override
    public void insertCard(ATMMachine machine, Card card) throws Exception {
        throw new Exception("Card already inserted.");
    }

    @Override
    public void authenticatePin(ATMMachine machine, int pin) throws Exception {
        Card card = machine.getCard();
        if(card.getPin()==pin) {
            System.out.println("PIN verification successful.");
            machine.setState(new SelectOperation());
        } else {
            System.out.println("Wrong PIN entered.");
            cancel(machine);
        }
    }

    @Override
    public void selectOperation(ATMMachine machine, ATMOperation operation) throws Exception {
        throw new Exception("Please enter your PIN first.");
    }

    @Override
    public void cashWithdrawl(ATMMachine machine, double amount) throws Exception {
        throw new Exception("Please enter your PIN first.");
    }

    @Override
    public void displayBalance(ATMMachine machine) throws Exception {
        throw new Exception("Please enter your PIN first.");
    }

    @Override
    public void changePin(ATMMachine machine) throws Exception {
        throw new Exception("Please enter your PIN first.");
    }

    @Override
    public void cancel(ATMMachine machine) throws Exception {
        System.out.println("Canceling Transaction.");
        returnCard(machine);
    }

    @Override
    public Card returnCard(ATMMachine machine) throws Exception {
        System.out.println("Please collect your card.");
        Card card = machine.getCard();
        machine.setState(null);
        machine.setState(new IdleState());
        return card;
    }

    @Override
    public void depositMoney(ATMMachine machine) throws Exception {
        throw new Exception("Please enter your PIN first.");
    }
}
