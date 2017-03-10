package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    Random rand= new Random();
    int butt = rand.nextInt(2);
    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */


    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof PigGameState)
        {

        PigGameState state = (PigGameState) info;

        if (((PigLocalGame) game).canMove(playerNum)) {
            if (butt == 0) {
                game.sendAction(new PigHoldAction(this));
            } else {
                game.sendAction(new PigRollAction(this));
            }
        } else {
            return;
        }
        }
    }//receiveInfo
}
