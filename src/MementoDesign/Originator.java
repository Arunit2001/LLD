package MementoDesign;

public class Originator {
    int x;
    int y;

    public Originator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Memento createMemento() {
        return new Memento(this);
    }

    public void restoreMemento(Memento m) {
        this.x = m.x;
        this.y = m.y;
    }
}
