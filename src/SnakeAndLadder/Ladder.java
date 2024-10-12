package SnakeAndLadder;

public class Ladder extends Cell{
    private final Cell new_position;

    public Ladder(Cell cell) {
        this.new_position = cell;
    }
    @Override
    public Cell getNewPosition() {
        System.out.println("Found ladder, advancing to position: " + new_position.currentPosition);
        return new_position;
    }
}
