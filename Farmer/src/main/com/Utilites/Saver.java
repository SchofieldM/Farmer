package main.com.Utilites;

// Internal Imports
    import main.com.Game.Player;

/**
 * Allows the Player to save the game
 *
 * @author Matthew Schofield
 * @version 1.14.18
 */
public class Saver {

// Fields
    // Player
        private Player player;

    /**
     * Creates the Saver to allow saving the game
     *
     * @param player, Player object running the game
     */
    public Saver(Player player)
    {
        this.player = player;
    }

    public boolean save()
    {
        return true;
    }

}
