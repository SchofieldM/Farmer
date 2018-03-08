package main.com.GUI;
// Java Lang
    // swing
        import javax.swing.JLabel;
        import javax.swing.ImageIcon;
    // awt
        import java.awt.Image;
    // net
        import java.net.URL;

/**
 * Enumerations for the img links of the program
 *
 * @author Matthew Schofield
 * @version 3.7.18
 */
public enum ImgLinks {

// Enumerations
	EmptyPlot("/Images/emptyPlot.png"),
    EmptyField("/Images/emptyField.png"),
    Farm("/Images/farmIcon.png"),
    FavIcon("/Images/farmIcon.png"),
    GameCover("/Images/farm.png"),
    Garage("/Images/garage.png"),
    GarageFloor("/Images/garageFloor.png"),
    GrassLand("/Images/grasslandMapIcon.png"),
    GrowingField("/Images/growingField.png"),
    Harvester("/Images/harvester.png"),
    HarvestReadyField("/Images/harvestReadyField.jpg"),
    MainBuilding("/Images/mainBuilding.png"),
    PlaceHolder("/Images/placeholder.png"),
    Planter("/Images/planter.png"),
    ;

// Construction of Enum

    // Field to store enumeration
    private final String imgLink;

// Constructor
    /**
     * Enumerates the img link
     *
     * @param imgLink, the img link to be enumerated
     */
    ImgLinks(final String imgLink) {
        this.imgLink = imgLink;
    }

// Method
    // String
    /**
     * Overrides the standard toString method so the enumerated Strings (img links) can be used
     *
     * @return the img link String
     */
    @Override
    public String toString() {
        return imgLink;
    }

    // URL
    /**
     * Accessor for the URL of the image
     *
     * @return the URL of the image
     */
    public URL getURL()
    {
        return this.getClass().getResource(imgLink);
    }

    // Image
    /**
     * Accessor for the Image linked to
     *
     * @return Image linked to
     */
    public Image getImage()
    {
        return getImageIcon().getImage();
    }

    // JLabel
    /**
     * Accessor method for a JLabel with a scaled ImageIcon of the linked Image
     *
     * @param width, the width of the Image/Label
     * @param height, the height of the Image/Label
     * @return a JLabel with the linked Image of given width and height
     */
    public JLabel getScaledLabel(int width, int height)
    {
        return new JLabel(new ImageIcon((new ImageGraphicsHandler()).scaleImage(getURL(), width, height)));
    }

    // ImageIcon
    /**
     * Accessor method for an ImageIcon of the linked Image with a given width and height
     *
     * @param width, width of Image
     * @param height, height of Image
     * @return ImageIcon with Image of given width and height
     */
    public ImageIcon getScaledImageIcon(int width, int height)
    {
        return new ImageIcon((new ImageGraphicsHandler()).scaleImage(getURL(), width, height));
    }

    /**
     * Accessor method for an ImageIcon of the linked Image
     *
     * @return an ImageIcon of the linked Image
     */
    public ImageIcon getImageIcon()
    {
        return new ImageIcon(getURL());
    }

}
