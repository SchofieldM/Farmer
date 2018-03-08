package main.com.Game.Buildings;

// Internal Imports
    // GUI
        import main.com.Game.Crops.Potato;
        import main.com.GUI.ImgLinks;
    // Game
        import main.com.Game.Crops.Crop;
        import main.com.Game.Crops.Corn;


/**
 * A 'building' where the player grows crops
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class Field extends Building {

// Fields
    // Crop
        private Crop crop;
    // int
        private int cropMaturity;
    // boolean
        private boolean readyToHarvest;

// Constructors
    /**
     *  Creates a field object with its crop
     *
     *  @param crop, crop to be planted in the field
     *  @param name, name of the field
     */
    public Field(Crop crop, String name)
    {
        super(name, "Field", ImgLinks.EmptyField);
        this.crop = crop;
        readyToHarvest = false;
    }

    /**
     * A field with a name, but no initial crop
     *
     * @param name, name of the field
     */
    public Field(String name)
    {
        super(name, "Field", ImgLinks.EmptyField);
        this.crop = null;
        readyToHarvest = false;
    }

    /**
     * A field without a name or initial crop
     */
    public Field()
    {
        super("Unnamed", "Field", ImgLinks.EmptyField);
        this.crop = null;
        readyToHarvest = false;
    }

// Methods

    // void
    /**
     * Plant seeds in the field
     *
     * @param seed, seed to plant
     */
    public void plant(String seed)
    {
        if(seed != null) {
            switch (seed) {
                case "Corn":
                    crop = new Corn();
                    break;
                case "Potato":
                    crop = new Potato();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * clears the field, setting the crop to null
     */
    public void clear()
    {
        crop = null;
        cropMaturity = 0;
    }

    /**
     * The field's crop fails, dies
     */
    public void cropFailure()
    {
        crop = null;
    }

    /**
     * The field's crop has a set back maturity wise
     */
    public void setBack()
    {
        if(crop != null) {
            cropMaturity--;
        }
    }

    /**
     * Matures the field by incrementing the crop's maturity, if the crop has matured enough then readyToHarvest
     * will be set to true allowing the field to be harvested
     */
    public void mature()
    {
        if(crop != null) {
            cropMaturity++;
            if (cropMaturity >= crop.getGrowthTime()) {
                readyToHarvest = true;
            }
        }
    }

    /**
     * Harvest the Field, if it is ready to be harvested the Field's crop is emptied and externally the Player gets the crop
     */
    public void harvest()
    {
        if(readyToHarvest) {
            crop = null;
            readyToHarvest = false;
        }
    }

    // int
    /**
     * Accessor method for the cropMaturity field, the maturity of the crop
     *
     * @return the cropMaturity of the field
     */
    public int getCropMaturity()
    {
        if(crop != null){
            return cropMaturity;
        }
        return -1;
    }

    // boolean
    /**
     * Accessor method for the readyToHarvest field, indicates if the field is ready for harvest
     *
     * @return a boolean indicating if the field is harvest ready
     */
    public boolean isReadyToHarvest()
    {
        return readyToHarvest;
    }


    // ImgLinks
    /**
     * Overrides the Building method, accessor method for the imgLink
     * the link to the icon for a field
     *
     * 3 different images, for the empty field, growing field and grown field
     *
     * @return the image for the Field
     */
    @Override
    public ImgLinks getImgLink()
    {
        if(crop != null){
            if(cropMaturity < crop.getGrowthTime()) {
                return ImgLinks.GrowingField;
            }else{
                return ImgLinks.HarvestReadyField;
            }
        }else{
            return ImgLinks.EmptyField;
        }
    }

    // String
    /**
     * Overrides the Object method toString
     *
     * @return {name}; {typeOfBuilding}; {crop} {"READY" or "" depending if field is ready to be harvested}
     */
    @Override
    public String toString()
    {
        String harvestReadyFlag;
        if(readyToHarvest){
            harvestReadyFlag = "READY";
        }else {
            if (!(crop == null)) {
                harvestReadyFlag = Integer.toString(crop.getGrowthTime() - cropMaturity);
            }else{
                harvestReadyFlag = "";
            }
        }
        return name + "; " + typeOfBuilding + "; " + crop + " "  + harvestReadyFlag;
    }

    // Crop
    /**
     * Accessor method for the crop field, the Crop growing in the Field
     *
     * @return the Crop growing in the Field
     */
    public Crop getCrop()
    {
        return crop;
    }

}
