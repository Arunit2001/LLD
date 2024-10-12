package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int minVal = 1;
    int maxVal = 6;

    public Dice(int no) {
        this.diceCount = no;
    }
    public int roll(){
        int totalSum=0;
        int diceUsed=0;
        while(diceUsed<diceCount){
            totalSum += ThreadLocalRandom.current().nextInt(minVal,maxVal+1);
            diceUsed++;
        }
        return totalSum;

    }
}
