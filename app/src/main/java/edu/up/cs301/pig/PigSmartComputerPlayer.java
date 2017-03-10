package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by frenchco19 on 3/9/2017.
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PigSmartComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof PigGameState)
        {
            if (((PigLocalGame) game).canMove(playerNum)) {
                if (((PigGameState) info).getCurrentRunningTotal() >= 20) {
                    game.sendAction(new PigHoldAction(this));
                } else {
                    game.sendAction(new PigRollAction(this));
                }
            } else {
                return;
            }
        }
    }
}
