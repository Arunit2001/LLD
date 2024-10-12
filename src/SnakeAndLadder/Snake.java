package SnakeAndLadder;

public class Snake extends Cell {
    private final Cell new_position;

    public Snake(Cell cell) {
        this.new_position = cell;
    }
    @Override
    public Cell getNewPosition() {
        System.out.println("Found snake, coming back to position: " + new_position.currentPosition);
        return new_position;
    }
}
