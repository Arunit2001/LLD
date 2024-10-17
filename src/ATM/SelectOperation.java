package ATM;

public class SelectOperation implements ATMState {
    public SelectOperation() {
        System.out.println("ATM is in SelectOperation stage.");
    }
    @Override
    public void insertCard(ATMMachine machine, Card card) throws Exception {
        throw new Exception("Card already inserted");
    }

    @Override
    public void authenticatePin(ATMMachine machine, int pin) throws Exception {
        throw new Exception("PIN already authenticated.");
    }

    @Override
    public void selectOperation(ATMMachine machine, ATMOperation operation) throws Exception {
        switch (operation) {
            case ATMOperation.CASH_WITHDRAWL -> machine.setState(new CashWithdrawlState());
            case ATMOperation.CHECK_BALANCE -> machine.setState(new CheckBalanceState());
            case ATMOperation.CHANGE_PIN -> machine.setState(new CashWithdrawlState());
            case ATMOperation.DEPOSIT_MONEY -> machine.setState(new CashWithdrawlState());
        }
    }

    @Override
    public void cashWithdrawl(ATMMachine machine, double amount) throws Exception {
        throw new Exception("Please select an operation to perform.");
    }

    @Override
    public void displayBalance(ATMMachine machine) throws Exception {
        throw new Exception("Please select an operation to perform.");
    }

    @Override
    public void changePin(ATMMachine machine) throws Exception {
        throw new Exception("Please select an operation to perform.");
    }

    @Override
    public void cancel(ATMMachine machine) throws Exception {
        System.out.println("Canceling transaction.");
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
        throw new Exception("Please select an operation to perform.");
    }
}
