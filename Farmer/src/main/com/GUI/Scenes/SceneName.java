package main.com.GUI.Scenes;

public enum SceneName {

// Enumerations
	FarmScene("Farm Scene"),
	GarageScene("Garage Scene"),
	InventoryScene("Inventory Scene"),
	MapScene("Map Scene"),
	StoreScene("Store Scene"),
    ;

// Construction of Enum

    // Field to store enumeration
    private final String name;

// Constructor
    /**
     * Enumerates the img link
     *
     * @param imgLink, the img link to be enumerated
     */
    SceneName(final String name) {
        this.name = name;
    }
    
 // Method
    // String
    /**
     * Overrides the standard toString method so the enumerated String (name) can be used
     *
     * @return the name of the Scene
     */
    @Override
    public String toString() {
        return name;
    }
	
}
