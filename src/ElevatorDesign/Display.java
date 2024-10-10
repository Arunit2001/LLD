package ElevatorDesign;

public class Display {
    int floor;
    Direction direction;

    public void update(int floor, Direction dir) {
        this.floor = floor;
        this.direction = dir;
    }
}
