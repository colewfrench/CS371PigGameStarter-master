package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by ajimine19 on 3/9/2017.
 */
public class PigHoldAction extends GameAction {

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PigHoldAction(GamePlayer player) {
        super(player);
    }
}
