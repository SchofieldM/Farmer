package main.com.Game;

/**
 * Handles turn operations for the game
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class TurnHandler {

    //Fields
        // int
            private int turnNumber;
        // Player
            private Player player;
        // RandomGameEventHandler
            private RandomGameEventHandler rgEventHandler;

    // Constructors

    /**
     * Creates the handler to handle turns for a Player and the game
     *
     * @param player, player using the game who the turns apply to
     */
    public TurnHandler(Player player)
    {
        this.player = player;
        rgEventHandler = new RandomGameEventHandler(player);
        turnNumber = 1;
    }

    // Methods

    // void
    /**
     * Accessor method for the turn number
     *
     * @return turn number
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }

    // int
    /**
     * Goes to the next turn
     *
     * @return the new turn number
     */
    public String nextTurn()
    {
        turnNumber++;
        return rgEventHandler.event() + rgEventHandler.randomMapEvent();
    }

}
