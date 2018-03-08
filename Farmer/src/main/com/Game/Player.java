package main.com.Game;

// Internal imports
    import main.com.Game.Buildings.Field;
    import main.com.Game.Buildings.Garage;
    import main.com.Game.MapObjects.Farm;

// Java
    import java.io.UncheckedIOException;
    import java.rmi.UnexpectedException;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Random;

/**
 * User who is playing the game
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class Player {

// Fields
    // String
        private String name;
    // Map
        private Map map;
    // int
        private int money;
        private int positiveEventLikelihood;
    // ArrayList
        private ArrayList<Farm> ownedFarms;
    // HashMap
        private HashMap<String, Integer> seedInventroy;
        private HashMap<String, Integer> grownCropsInventroy;
    // Store
        private Store store;
    // RandomGameEventHandler
        private TurnHandler turnHandler;


// Constructors
    /**
     * Creates a player to then play the game
     *
     * @param name, name of the user
     * @param money, amount of money to have user start with
     */
    public Player(String name, int money)
    {
        this.turnHandler = new TurnHandler(this);
        if(money >= 0) {
            this.money = money;
        }else{
            this.money = 0;
        }
        this.map = new Map();
        this.name = name;
        this.ownedFarms = new ArrayList<>();
        this.store = new Store(this);
        this.seedInventroy = new HashMap<>();
        seedInventroy.put("Corn", 0);
        seedInventroy.put("Potato", 0);
        this.grownCropsInventroy = new HashMap<>();
        grownCropsInventroy.put("Corn", 0);
        grownCropsInventroy.put("Potato", 0);
        this.positiveEventLikelihood = 50;
    }

    /**
     * Creates a player to then play the game
     *
     * @param name, name of the user
     * @param money, amount of money to have user start with
     * @param positiveEventLikelihood, likelihood for a positive event to happen out
     *        of 100
     */
    public Player(String name, int money, int positiveEventLikelihood)
    {
        this.turnHandler = new TurnHandler(this);
        if(money >= 0) {
            this.money = money;
        }else{
            this.money = 0;
        }
        this.map = new Map();
        this.name = name;
        this.ownedFarms = new ArrayList<>();
        this.store = new Store(this);
        this.seedInventroy = new HashMap<>();
        seedInventroy.put("Corn", 0);
        seedInventroy.put("Potato", 0);
        this.grownCropsInventroy = new HashMap<>();
        grownCropsInventroy.put("Corn", 0);
        grownCropsInventroy.put("Potato", 0);
        this.positiveEventLikelihood = positiveEventLikelihood;
    }

// Methods

    // void

    /**
     * Add or subtract Money to or from a player's money
     *
     * @param amount amount to add or subtract
     */
    public void changeMoney(int amount)
    {
        money += amount;
        if(money < 0){
            System.out.println("Bankruptcy!");
            System.exit(0);
        }
    }

    /**
     * Add a farm to Game.Player's property
     *
     * @param farm, farm to add
     */
    public void addFarm(Farm farm)
        {
            ownedFarms.add(farm);
        }

    /**
     * Have the player go to sleep
     *
     * Pass a turn/day
     */
    public String sleep()
    {

        for(Farm farm : ownedFarms){
            farm.matureFields();
        }
        return turnHandler.nextTurn();
    }

    /**
     * Have Player harvest a Field
     *
     * @param field, Field to harvest
     */
    public void harvestField(Field field)
    {
        if(field.isReadyToHarvest()) {
            grownCropsInventroy.put(field.getCrop().getName(), grownCropsInventroy.get(field.getCrop().getName()) + field.getCrop().getAmountPerField());
            field.clear();
        }else{
            System.out.print("Not Ready");
        }
    }
    /**
     * Adds seed to inventory
     *
     * @param seed, seed to add to inventory
     * @param amount, amount of seed to add
     */
    public void addSeedToInventory(String seed, int amount)
    {
        seedInventroy.put(seed, seedInventroy.get(seed) + amount);
    }

    /**
     * Sets the Player's seed inventory to empty
     */
    public void setSeedInventoryEmpty()
    {
        seedInventroy.put("Corn", 0);
        seedInventroy.put("Potato", 0);
    }

    // Map
    public Map getMap()
    {
        return map;
    }

    // TurnHandler

    /**
     * Accessor method for te Player's TurnHandler
     * @return Player's TurnHandler
     */
    public TurnHandler getTurnHandler() {
        return turnHandler;
    }

    // boolean

    /**
     * Whether or not the player has a Farm
     *
     * @return true: Player has a Farm; false: Player does not have a Farm
     */
    public boolean hasAFarm()
    {
        if(ownedFarms.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    //String

    /**
     * Accessor method for the name field
     *
     * @return name field
     */
    public String getName()
{
    return name;
}



    /**
     * Plants a field based on a given farm index and field index, with a seed specified by a String
     *
     * @param seed, String representation of seed to plant
     */
    public String plantField(Farm farm, Field field, String seed)
    {
        if(seedInventroy.get(seed) > 0) {
            seedInventroy.put(seed, seedInventroy.get(seed) - 1);
            farm.plantField(field, seed);
            return "Planted " + seed;
        }else{
            return "Not enough seed";
        }
    }

    /**
     * Lists the seed inventory of the Game.Player
     *
     * @return the seed inventory
     */
    public String listSeedInventory()
    {
        String output = "Seed Inventory: \n";
        for(String seed : seedInventroy.keySet()){
            output += "\t" + seed + " : " + seedInventroy.get(seed) + "\n";
        }
        return  output;
    }

    /**
     * Lists the grown crop inventory
     *
     * @return the grown crop inventory
     */
    public String listGrownCropsInventory()
    {
        String output = "Crop Inventory: \n";
        for(String crop : grownCropsInventroy.keySet()){
            output += "\t" + crop + " : " + grownCropsInventroy.get(crop) + "\n";
        }
        return  output;
    }

    /**
     * Lists full inventory of Game.Player
     *
     * @return the inventory
     */
    public String listInventory()
    {
        String output = listSeedInventory() + listGrownCropsInventory();
        return output;
    }

    /**
     * List a player's properties
     *
     * @return all properties owned by the player
     */
    public String properties()
    {
        String output = "";
        int i = 0;
        for(Farm farm : ownedFarms){
            output += (i + ": " + farm.getName() + "\n");
            i++;
        }
        return output;
    }

    /**
     * Sells all crops that are grown
     * @return monetary balance
     */
    public String sellAllGrownCrops()
    {
        String output = "";
        for(String crop : grownCropsInventroy.keySet()){
            switch (crop){
                case "Corn":
                    money += store.getValueOf("Corn Crop") * grownCropsInventroy.get(crop);
                    grownCropsInventroy.put("Corn", 0);
                    break;
                case "Potato":
                    money += store.getValueOf("Potato Crop") * grownCropsInventroy.get(crop);
                    grownCropsInventroy.put("Potato", 0);
                    break;
                default:
                    throw new IllegalArgumentException("Error F001");
            }
        }
        output += money;
        return output;
    }

    /**
     * Purchase seed
     *
     * @param seed, name of type of seed to plants, valid inputs: "Game.Corn"
     * @param amount, amount to purchase
     * @return a message whether a succesful purchase occured
     */
    public String purchaseSeed(String seed, int amount)
    {
        switch (seed){
            case "Corn":
                store.makeASaleOfSeeds(seed, amount);
                return "Succesful purchase of " + amount + " units of Corn";
            case "Potato":
                store.makeASaleOfSeeds(seed, amount);
                return "Succesful purchase of " + amount + " units of Potatoes";
        }
        return "ERROR F001";
    }

    public void purchaseMachine(String machine)
    {
        store.makeASaleOfAMachine(machine);
    }

    /**
     * Purchase a farm
     *
     * @return success message
     */
    public Farm purchaseFarm()
    {
        Farm farm = store.makeASaleOfAFarm();
        return farm;
    }

    public Farm getRandomFarm()
    {
        return ownedFarms.get((new Random()).nextInt(ownedFarms.size()));
    }

    /**
     *
     *
     * @param farm
     * @param x
     * @param y
     * @return
     */

    public String purchaseGarage(Farm farm, int x, int y)
    {
        int farmIndex = ownedFarms.indexOf(farm);
        store.makeASaleOfAGarage(farmIndex, x, y);
        return "Succesful purchase of a Garage";
    }

    /**
     * Purchases a Field
     *
     * @param farm, Farm to build field on
     * @param x, xcoord to build the Field
     * @param y, y coord to build the Field
     */
    public String purchaseField(Farm farm, int x, int y)
    {
        int farmIndex = ownedFarms.indexOf(farm);
        store.makeASaleOfAField(farmIndex, x, y);
        return "Succesful purchase of a farm";
    }

    // int
    /**
     * Accessor method for the positiveEventLikelihood
     *
     * @return positiveEventLikelihood, the likely hood of a positive event out of 100
     */
    public int getPositiveEventLikelihood()
    {
        return positiveEventLikelihood;
    }

    /**
    * Accessor method for the money field
     *
     * @return money field
     */
    public int getMoney()
        {
            return money;
        }

    // ArrayList

    /**
     * Accessor method for the Game.Player's ArrayList of owned farms
     *
     * @return player's owned farms, ArrayList
     */
    public ArrayList<Farm> getOwnedFarms() {
        return ownedFarms;
    }
}
