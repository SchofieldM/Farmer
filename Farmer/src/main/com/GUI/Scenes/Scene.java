package main.com.GUI.Scenes;

// Java Lang
    import javax.swing.JPanel;
    import javax.swing.JLabel;

/**
 * For inheritance, creates Scenes to load into the GUI for the player to interact with the game
 *
 * @author Matthew Schofield
 * @version 12.31.17
 */
public abstract class Scene {

// Fields
    // JPanel
        protected JPanel scene;
    // String
        protected String sceneName;

// Constructor

    /**
     * Initializes necessary fields for inheritance purposes
     *
     * Most importantly a null scene which will be loaded with a JPanel to show the Player
     * and
     * a scene name for identification
     *
     * @param sceneName to allow the program to identify the scene coherently
     */
    public Scene(String sceneName)
    {
        this.scene = null;
        this.sceneName = sceneName;
    }

    /**
     * To access the scene JPanel once built
     *
     * @return the scene JPanel
     */
    public JPanel getScene() {
        if(scene != null) {
            return scene;
        }else{
            JPanel errorPanel = new JPanel();
            errorPanel.add(new JLabel("Error 003"));
            return errorPanel;
        }
    }

    /**
     * The scene's name
     *
     * @return the scene's name
     */
    public String getSceneName()
    {
        return sceneName;
    }
}
