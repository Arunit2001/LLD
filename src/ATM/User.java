package ATM;

public class User {
    static int nextId = 1;
    int id;
    String name;
    BankAccount account;
    Card card;

    public User(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
