package MementoDesign;

public class Main {
    public static void main(String args[]) {
        Originator config = new Originator(2,3);
        Memento m = config.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.addToHistory(m);
        config.setX(12);
        m = caretaker.undo();
        config.restoreMemento(m);
        System.out.println(config.getX() + ", " +config.getY());
    }
}
