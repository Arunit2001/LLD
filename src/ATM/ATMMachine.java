package ATM;

public class ATMMachine {
    static int nextId = 1;
    final int id;
    ATMState state;
    Card card;

    public ATMMachine() {
        this.id = nextId++;
        this.state = new IdleState();
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
