package main.com.GUI;

// Java Lang
    // swing
        import javax.swing.ImageIcon;
    // awt
        import java.awt.Image;
        import java.net.URL;

/**
 * To handle graphics for the programs GUI
 *
 * @author Matthew Schofield
 * @version 1.4.18
*/
public class ImageGraphicsHandler
{

    /**
     * Generic constructor only to give access to methods
     */
    public ImageGraphicsHandler()
    {
    }

    /**
     * Scales an image to a given height and width, maintains image does not crop
     *
     * @param imgLink, link to image to scale
     * @param width, new width of image
     * @param height, new height of image
     * @return scaled image
     */
    public Image scaleImage(URL imgLink, int width, int height)
    {
        // Creates an ImageIcon to then extract the Image from
        ImageIcon initialImage = new ImageIcon(imgLink);

        // Extracts the Image from the ImageIcon
        Image transformReadyImage = initialImage.getImage();

        // Transforms the image
        Image scaledImage = transformReadyImage.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);

        // Returns scaled Image
        return scaledImage;
    }
    public Image scaleImage(String imgLink, int width, int height)
    {
        // Creates an ImageIcon to then extract the Image from
        ImageIcon initialImage = new ImageIcon(imgLink);

        // Extracts the Image from the ImageIcon
        Image transformReadyImage = initialImage.getImage();

        // Transforms the image
        Image scaledImage = transformReadyImage.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);

        // Returns scaled Image
        return scaledImage;
    }

}
