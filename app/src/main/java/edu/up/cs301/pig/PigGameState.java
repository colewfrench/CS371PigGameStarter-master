package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by frenchco19 on 3/9/2017.
 */
public class PigGameState extends GameState {

    int playerID;
    int player0Score;
    int player1Score;
    int currentRunningTotal;
    int dieValue;

    public PigGameState()
    {
        this.playerID = 0;
        this.player0Score = 0;
        this.player1Score = 0;
        this.currentRunningTotal = 0;
        this.dieValue = 0;
    }

    public PigGameState(PigGameState orig)
    {
        this.playerID = orig.getPlayerID();
        this.player0Score = orig.getPlayer0Score();
        this.player1Score = orig.getPlayer1Score();
        this.currentRunningTotal = orig.getCurrentRunningTotal();
        this.dieValue = orig.getDieValue();
    }

    public int getPlayerID()
    {
        return this.playerID;
    }

    public void setPlayerID(int newID)
    {
        this.playerID = newID;
    }

    public int getPlayer0Score()
    {
        return this.player0Score;
    }

    public void setPlayer0Score(int newPlayer0Score)
    {
        this.player0Score = newPlayer0Score;
    }

    public int getPlayer1Score()
    {
        return this.player1Score;
    }

    public void setPlayer1Score(int newPlayer1Score)
    {
        this.player1Score = newPlayer1Score;
    }

    public int getCurrentRunningTotal()
    {
        return this.currentRunningTotal;
    }

    public void setCurrentRunningTotal(int newCurTotal)
    {
        this.currentRunningTotal = newCurTotal;
    }

    public int getDieValue()
    {
        return this.dieValue;
    }

    public void setDieValue(int newDieVal)
    {
        this.dieValue = newDieVal;
    }
}
