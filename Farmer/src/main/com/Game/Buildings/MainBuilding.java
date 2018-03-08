package main.com.Game.Buildings;

// Internal Imports
    // GUI
        import main.com.GUI.ImgLinks;
        import main.com.Game.MapObjects.Farm;

/**
 * Main Building of a Farm for direct managerial changes to a farm
 *
 * @author Matthew Schofield
 * @version 1.1.18
 */
public class MainBuilding extends Building {

// Fields
    private Farm farm;

// Constructors

    /**
     * Constructs the main building of a farm
     *
     * @param farm, the Farm managed by this Main Building
     */
    public MainBuilding(Farm farm)
    {
        super("Main Building", "Main Building", ImgLinks.MainBuilding);
        this.farm = farm;
    }

// Methods

    /**
     * Renames the farm the Main Building governs
     *
     * @param newName
     * @return if success: {the new name}; if failure: "Error: 004"
     */
    public String renameFarm(String newName) {
        if (newName != null && !newName.equals("") && !newName.equals("Error: 004")){
            farm.setName(newName);
            return newName;
        }else{
            return "Error: 004";
        }
    }

}
