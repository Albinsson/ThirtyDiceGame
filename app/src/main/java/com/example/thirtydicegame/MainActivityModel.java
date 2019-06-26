package com.example.thirtydicegame;

import java.util.Random;

public class MainActivityModel implements MainActivityContract.Model {

    private int throwCounter = 0;
    private int throwMax = 3;

    private int roundCounter = 0;
    private int roundMax = 10;

    private int [] diceValues = {0,0,0,0,0,0};
    private boolean [] diceHold = {false,false,false,false,false,false};


    public boolean[] getDiceHold() {
        return diceHold;
    }

    public void setDiceHold(boolean[] diceHold) {
        this.diceHold = diceHold;
    }


    public int [] getDice() {

        if (throwCounter == 0 && roundCounter ==0){initNewGame();}

        rollDice();

        int die1 = getImage(1);
        int die2 = getImage(2);
        int die3 = getImage(3);
        int die4 = getImage(4);
        int die5 = getImage(5);
        int die6 = getImage(6);

        int diceDrawables [] = new int[] {die1,die2,die3,die4,die5,die6};
        return diceDrawables;
    }

    private void initNewGame() {

    }

    public int getImage(int dieNumber){

        int index = dieNumber -1;

        boolean isOnHold = this.diceHold[index];

        int dieValue = this.diceValues[index];


        switch (dieValue){
            case 1: return isOnHold? R.drawable.grey1 : R.drawable.white1;
            case 2: return isOnHold? R.drawable.grey2 : R.drawable.white2;
            case 3: return isOnHold? R.drawable.grey3 : R.drawable.white3;
            case 4: return isOnHold? R.drawable.grey4 : R.drawable.white4;
            case 5: return isOnHold? R.drawable.grey5 : R.drawable.white5;
            case 6: return isOnHold? R.drawable.grey6 : R.drawable.white6;
        }
        return 0;
    }

    @Override
    public void toggleDieHold(int dieNumber) {
        this.diceHold[dieNumber-1] = !this.diceHold[dieNumber-1];
    }

    @Override
    public String getRoundCounter() {
        return Integer.toString(roundCounter);
    }

    public String getThrowCounter() {
        return Integer.toString(throwCounter);
    }



    @Override
    public void rollDice () {

        int dice1 = diceHold[0]? diceValues[0] : new Random().nextInt(6)+1;
        int dice2 = diceHold[1]? diceValues[1] : new Random().nextInt(6)+1;
        int dice3 = diceHold[2]? diceValues[2] : new Random().nextInt(6)+1;
        int dice4 = diceHold[3]? diceValues[3] : new Random().nextInt(6)+1;
        int dice5 = diceHold[4]? diceValues[4] : new Random().nextInt(6)+1;
        int dice6 = diceHold[5]? diceValues[5] : new Random().nextInt(6)+1;

        int[] rolledDice = new int[] {dice1,dice2,dice3,dice4,dice5,dice6};
        this.diceValues = rolledDice;
    }
}
