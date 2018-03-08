package main.com.Game.Crops;

/**
 * Abstract classes for inheritance to create crop sub classes
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public abstract class Crop {

// Fields
    // String
        protected String name;
    // int
        protected int value;
        protected int amountPerField;
        protected int growthTime;

// Constructors

    /**
     * For inheritance purposes of a crop
     *
     * @param name name of the crop
     * @param amountPerField how much crop a field yeilds
     */
    public Crop(String name, int amountPerField, int growthTime)
    {
        this.name = name;
        this.amountPerField = amountPerField;
        this.growthTime = growthTime;
    }

// Methods

    // String

    /**
     * The standard toString method
     * @return name of the crop
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     *Accessor method for the crop's name
     *
     * @return the name of the crop
     */
    public String getName()
        {
            return name;
        }

    // int
    /**
     * Accessor method for the amount that a field would yield
     *
     * @return the amount of crop a field would yield
     */
    public int getAmountPerField()
    {
        return amountPerField;
    }

    /**
     * Accessor method for how much a crop sells for
     *
     * @return the amount a unit of the crop sells for
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Accessor method for the crop's growthTime
     *
     * @return the growth time of a crop
     */
    public int getGrowthTime()
    {
        return growthTime;
    }

}
