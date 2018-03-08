package main.com.Game.MapObjects;

// Internal imports
    // GUI
        import main.com.GUI.ImgLinks;


/**
 * Abstract class to build off of in creating Objects to be displayed on the game Map
 */
public abstract class MapObject {

    // Fields
        // ImgLinks
            protected ImgLinks imgLink;
        // String
            protected String type;

    /**
     * For inheritance
     *
     * @param type, type of object on the Map
     * @param imgLink, link to the object's graphical resources
     */
    public MapObject(String type, ImgLinks imgLink)
    {
        this.imgLink = imgLink;
        this.type = type;
    }

    // Method

    // ImgLinks

    /**
     * Accessor method for the graphical resources of the area
     *
     * @return graphical resources of the area
     */
    public ImgLinks getImgLink()
    {
        return imgLink;
    }

    // String

    /**
     * Accessor method for the type of area on the Map
     * @return the type of area on the Map
     */
    public String getType()
    {
        return type;
    }

}
