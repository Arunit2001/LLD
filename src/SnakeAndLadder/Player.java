package SnakeAndLadder;

public class Player {
    static int nextId = 1;
    int id;
    String name;
    private int currentPosition;

    public Player(String name) {
        this.id = nextId++;
        this.name = name;
        this.currentPosition = 0;
    }
    public void setCurrentPosition(int pos) {
        this.currentPosition = pos;
        System.out.println("Player " + name + " new position : " + this.currentPosition);
    }
    public int getCurrentPosition() {
        System.out.println("Player " + name + " current position : " + this.currentPosition);
        return currentPosition;
    }
}
