package main.com.Game;

// Internal Imports
    import main.com.Game.Buildings.Field;
    import main.com.Game.MapObjects.Farm;

// Java
    import java.util.Random;

/**
 * For random events to occur in the game
 *
 * @author Matthew Schofield
 * @version 1.6.18
 */
public class RandomGameEventHandler {

// Fields
    // Random
        private Random random;
    // Player
        private Player player;
    // int
        private int chanceOfPositiveEvent;
        private int roll;

    /**
     * Create random event handler to have random events happen to the player
     */
    public RandomGameEventHandler(Player player)
    {
        random = new Random();
        this.player = player;
        chanceOfPositiveEvent = player.getPositiveEventLikelihood();
    }

    /**
     * Have a random event occur
     */
    public String event()
    {
        int rand = random.nextInt(100);
        if(chanceOfPositiveEvent > rand){
            return positiveEvent();
        }else{
            return negativeEvent();
        }
    }

    public boolean within(int start, int end)
    {
        if(roll >= start && roll <= end){
            return true;
        }
        return false;
    }

    public String positiveEvent()
    {
        roll = random.nextInt(1000);
        if(within(0,10)){
            player.changeMoney(10);
            return "You found a $10 bill";
        }else if(within(11, 111)){
            Farm farm = player.getRandomFarm();
            for(Field field : farm.getFields()){
                field.mature();
            }
            return "Good weather has caused extra growth on " + farm.getName();
        }
        return "Nothing happened";
    }

    public String negativeEvent()
    {
        roll = random.nextInt(1000);
        return "Nothing happened";
    }

    public String randomMapEvent()
    {
        roll = random.nextInt(1000);
        if(within(0, 100)){
            player.getMap().createATown();
            return "A town was formed";
        }
        return "";
    }

}
