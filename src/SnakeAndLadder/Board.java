package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int rSize;
    int cSize;
    Cell[][] cells;

    public Board(int rows, int cols, int noOfSnakes, int noOfLadders) {
        this.rSize = rows;
        this.cSize = cols;
        initializeCells();
        addSnakeAndLadders(noOfSnakes, noOfLadders);
    }
    public void initializeCells() {
        cells = new Cell[this.rSize][this.cSize];
        for(int i = 0; i<rSize; i++) {
            for(int j = 0; j<cSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
                cellObj.currentPosition = i*cSize + j+1;
            }
        }
    }
    public void addSnakeAndLadders(int noOfSnakes, int noOfLadders) {
        // -1 because don't want to put snake/ladder on the winning piece and 1 in beginning to not put ladder on the very first element.
        while(noOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,this.rSize*this.cSize-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,this.rSize*this.cSize-1);
            if(snakeTail >= snakeHead) {
                continue;
            }
            Cell snakeTailCell = getCell(snakeTail);
            addNewSnake(snakeHead, snakeTailCell);
            noOfSnakes--;
        }
        while(noOfLadders > 0) {
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,this.rSize*this.cSize-1);
            int ladderStart = ThreadLocalRandom.current().nextInt(1,this.rSize*this.cSize-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }
            Cell ladderEndCell = getCell(ladderEnd);
            addNewLadder(ladderStart, ladderEndCell);
            noOfLadders--;
        }

    }
    public void addNewSnake(int pos, Cell snakeEnd) {
        int row = pos / this.rSize;
        int col = pos % this.cSize;
        cells[row][col] = new Snake(snakeEnd);
        cells[row][col].currentPosition = pos;
    }
    public void addNewLadder(int pos, Cell ladderEnd) {
        int row = pos / this.rSize;
        int col = pos % this.cSize;
        cells[row][col] = new Ladder(ladderEnd);
        cells[row][col].currentPosition = pos;
    }

    public Cell getCell(int pos) {
        int row = pos / this.rSize;
        int col = pos % this.cSize;
        return cells[row][col];
    }
}
