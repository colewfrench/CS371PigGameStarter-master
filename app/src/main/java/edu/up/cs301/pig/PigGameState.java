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

    public PigGameState(int initCurPlayer,
                        int initPlayer0Score,
                        int initPlayer1Score,
                        int initCurRunningTotal,
                        int initDieVal)
    {
        this.playerID = initCurPlayer;
        this.player0Score = initPlayer0Score;
        this.player1Score = initPlayer1Score;
        this.currentRunningTotal = initCurRunningTotal;
        this.dieValue = initDieVal;
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
