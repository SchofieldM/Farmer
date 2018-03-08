package main.com.Game.Buildings;

// Internal Imports
    // GUI
        import main.com.GUI.ImgLinks;


/**
 * For buildings to inherit from
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public abstract class Building {

// Fields
    // String
        protected String name;
        protected String typeOfBuilding;
        protected ImgLinks imgLink;

// Constructors

    /**
     * Creates a building with a specified name and of a specified type
     *
     * @param name, name of the building
     * @param typeOfBuilding, type of building
     * @param imgLink, the link to the buildings default picture, these links are enumerated in
     *                 ImgLinks in the GUI package
     */
    public Building(String name, String typeOfBuilding, ImgLinks imgLink)
    {
        this.imgLink = imgLink;
        this.name = name;
        this.typeOfBuilding = typeOfBuilding;
    }

// Methods

    // String
    /**
     * Overrides the toString method returning the buildings name and typeOfBuilding
     *
     * @return  {name; typeOfBuilding}
     * */
    @Override
    public String toString()
    {
        return name + "; " + typeOfBuilding;
    }

    /**
     * Accessor method for the name of the Building
     *
     * @return name; name of the building
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method for the typeOfBuilding
     *
     * @return typeOfBuilding, type of the building
     */
    public String getTypeOfBuilding()
    {
        return typeOfBuilding;
    }

    // void
    /**
     * Sets the name of the building
     *
     * @param newName, the newName of the building
     */
    public void setName(String newName)
    {
        name = newName;
    }

    // ImgLinks
    /**
     * Accessor method for the imgLink
     *
     * @return imgLink, link to the image file for the building
     */
    public ImgLinks getImgLink()
    {
        return imgLink;
    }
}