package main.com.Game;

// Internal Imports
    import main.com.Game.Buildings.Garage;
    import main.com.Game.Machines.Harvester;
    import main.com.Game.Machines.Machine;
    import main.com.Game.MapObjects.Farm;
    import main.com.Game.Buildings.Field;

// Java
    import java.util.HashMap;

/**
 * Store for the player to purchase and sell goods
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class Store {

// Fields
    // Player
        private Player player;
    // HashMap
        private HashMap<String, Integer> valuations;


    /**
     * Creates a store for the player to buy and sell goods
     *
     * @param player, player to buy and sell goods
     */
    public Store(Player player)
    {
        this.player = player;
        valuations = new HashMap<>();
        valuations.put("Corn Seed", 100);
        valuations.put("Corn Crop", 3);
        valuations.put("Potato Seed", 50);
        valuations.put("Potato Crop", 2);
        valuations.put("Farm", 5000);
        valuations.put("Field", 500);
        valuations.put("Garage", 500);
        valuations.put("Harvester", 1000);
        valuations.put("Planter", 1000);
    }

    //void
    /**
     * Make a sale of seeds
     *
     * @param seed seed to sell
     * @param amount amount to sell
     */
    public void makeASaleOfSeeds(String seed, int amount)
    {
        player.addSeedToInventory(seed, amount);
        int value = 0;
        switch (seed){
            case "Corn":
                value = valuations.get("Corn Seed");
                break;
            case "Potato":
                value = valuations.get("Potato Seed");
                break;
        }
        int toCharge = value * amount;
        player.changeMoney(-1 * toCharge);
    }

    /**
     * Accessor method for the value of an item
     */
    public int getValueOf(String item)
    {
        return valuations.get(item);
    }

    /**
     * Make a sale of a farm
     */
    public Farm makeASaleOfAFarm()
    {
        Farm farm = new Farm("Main Farm");
        player.addFarm(farm);
        player.changeMoney(-1 * valuations.get("Farm"));
        return farm;
    }


    /**
     * Sell the player a Field
     *
     * @param farmIndex, Farm to build Field on
     * @param x, x coord to build Field
     * @param y, y coord to build the Field
     * @return the created Field
     */
    public Field makeASaleOfAField(int farmIndex, int x, int y)
    {
        player.changeMoney(-1 * valuations.get("Field"));
        Field field = new Field(null, "Unnamed");
        player.getOwnedFarms().get(farmIndex).build(field, x, y);
        return field;
    }

    public Garage makeASaleOfAGarage(int farmIndex, int x, int y)
    {
        player.changeMoney(-1 * valuations.get("Garage"));
        Garage garage = new Garage(player.getOwnedFarms().get(farmIndex), player);
        player.getOwnedFarms().get(farmIndex).build(garage, x, y);
        return garage;
    }

    public void makeASaleOfAMachine(String machine)
    {
        player.changeMoney(-1 * valuations.get(machine));
    }

}

