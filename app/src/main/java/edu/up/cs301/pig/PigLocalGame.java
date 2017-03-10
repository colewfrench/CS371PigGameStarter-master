package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private static final int WINNING_SCORE = 50;

    private PigGameState masterPigState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        this.masterPigState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == masterPigState.getPlayerID()) return true;

        // else
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigRollAction)
        {
            // roll
            Random rand = new Random();
            int dieVal = rand.nextInt(6) + 1;
            if (dieVal != 1)
            {
                int newTotal = masterPigState.getCurrentRunningTotal() + dieVal;
                masterPigState.setCurrentRunningTotal(newTotal);
            }
            else
            {
                masterPigState.setCurrentRunningTotal(0);
                masterPigState.setPlayerID(1 - masterPigState.getPlayerID());
            }

            return true;
        }
        else if (action instanceof PigHoldAction)
        {
            // hold
            if (masterPigState.getPlayerID() == 0)
            {
                // player 0
                int updatedScore = masterPigState.getCurrentRunningTotal() + masterPigState.getPlayer0Score();
                masterPigState.setPlayer0Score(updatedScore);
            }
            else
            {
                // player 1
                int updatedScore = masterPigState.getCurrentRunningTotal() + masterPigState.getPlayer1Score();
                masterPigState.setPlayer1Score(updatedScore);
            }

            masterPigState.setPlayerID(1 - masterPigState.getPlayerID());
            return true;
        }

        // else take no action
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copyState = new PigGameState(masterPigState);
        p.sendInfo((GameState)copyState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (masterPigState.getPlayer0Score() >= WINNING_SCORE)
        {
            return ("Player 1 has won with " + masterPigState.getPlayer0Score() + "points.");
        }
        else if (masterPigState.getPlayer1Score() >= WINNING_SCORE)
        {
            return ("Player 2 has won with " + masterPigState.getPlayer1Score() + "points.");
        }

        return null;
    }

}// class PigLocalGame
