package MementoDesign;

public class Memento {
    int x;
    int y;

    public Memento(Originator origin) {
        this.x = origin.x;
        this.y = origin.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
