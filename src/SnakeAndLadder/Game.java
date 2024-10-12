package SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> playerList = new LinkedList<Player>();
    Dice dice;
    Player winner;

    public void initializeGame() {
        board = new Board(10, 10, 5, 5);
        playerList.add(new Player("A"));
        playerList.add(new Player("B"));
        playerList.add(new Player("C"));
        dice = new Dice(1);
        winner = null;
        startGame();
    }
    public void startGame() {
        while(winner == null) {
            Player currentPlayer = playerList.poll();
            assert currentPlayer != null;
            playerList.add(currentPlayer);
            int steps = dice.roll();
            int playerCurrentPosition = currentPlayer.getCurrentPosition();
            int playerNewPosition = newPositionCheck(playerCurrentPosition, steps);
            Cell playerNewCell = board.getCell(playerNewPosition);
            playerNewCell = playerNewCell.getNewPosition();
            playerNewPosition = playerNewCell.currentPosition;
            //Winning Logic
            if(playerNewPosition >= board.rSize * board.cSize-1){
                winner = currentPlayer;
                break;
            }
            currentPlayer.setCurrentPosition(playerNewPosition);
        }
        System.out.println("Winner is " + winner.name);
    }
    public int newPositionCheck(int oldPos, int steps) {
        if(oldPos+steps >= board.rSize * board.cSize-1){
            return oldPos;
        }
        return oldPos + steps;
    }
}
