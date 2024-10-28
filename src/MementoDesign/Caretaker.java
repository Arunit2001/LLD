package MementoDesign;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
    Stack<Memento> history;
    public Caretaker() {
        this.history = new Stack<>();
    }
    public void addToHistory(Memento m) {
        history.add(m);
    }
    public Memento undo() {
        if(!history.empty()){
            return history.pop();
        }
        return null;
    }
}
