package main.com.GUI.Scenes;

// Internal Imports
    // GUI
        import main.com.GUI.ImageGraphicsHandler;
        import main.com.GUI.GUI;
    // Game
        import main.com.Game.Map;
        import main.com.Game.MapObjects.Farm;
// Java Lang
    // javax.swing
        import javax.swing.JPanel;
        import javax.swing.JButton;
        import javax.swing.JLabel;
    // java.awt
        import java.awt.GridBagConstraints;
        import java.awt.GridBagLayout;
        import java.awt.Dimension;

/**
 * A scene to allow the Player to interact with the program's Map
 *
 * @author Matthew Schofield
 * @version 1.16.18
 */
public class MapScene extends Scene {

//Fields
    // Map
        private Map map;
    // GUI
        private GUI gui;
    // GridBagConstrants
        private GridBagConstraints constraints;
    // ImageGraphicsHandler
        private ImageGraphicsHandler imgGrphHandler;
    // JPanel
        private JPanel mpPanel;

// Constructors

    /**
     * Creates a MapScene for the Player to interact with
     *
     * @param gui, the gui for the scene to be represented in
     * @param map, the map for the scene to display
     */
    public MapScene(GUI gui, Map map)
    {
        super(SceneName.MapScene);
        this.map = map;
        this.gui = gui;
        this.imgGrphHandler = new ImageGraphicsHandler();
        createMapPanel();
    }

// Methods

    /**
     * Creates the JPanel to represent the scene
     */
    private void createMapPanel()
    {
        this.scene = new JPanel();
        scene.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        mpPanel = new JPanel();
        mpPanel.setLayout(new GridBagLayout());
        scene.add(mpPanel);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                constraints.fill = 80;
                constraints.weightx = 1;
                constraints.gridx = i;
                constraints.gridy = j;
                JButton button = mapObjectToButton(i, j);
                mpPanel.add(button, constraints);
            }
        }
        JLabel information = new JLabel("Money: " + gui.getPlayer().getMoney());
        constraints.gridx = 0;
        constraints.gridy = 3;
        mpPanel.add(information, constraints);
    }

    /**
     * Turns a MapObject into a JButton for representation in the scene
     *
     * @param x, the x coordinate of the MapObject
     * @param y, the y coordinate of the MapObject
     * @return a JButton representation of the MapObject at the coordinate x,y
     */
    private JButton mapObjectToButton(int x, int y)
    {
        JButton button = new JButton(map.getCell(x, y).getImgLink().getScaledImageIcon(80, 60));
        switch (map.getCell(x,y).getType()){
            case "Grassland":
                createGrasslandButton(button,x,y);
                break;
            case "Farm":
                createFarmButton(button,x,y);
                break;
        }
        button.setPreferredSize(new Dimension(80,60));
        return button;
    }

    /**
     * Turns a JButton into a representation of a GrassLand
     *
     * @param button, JButton to to turn into a GrassLand
     * @param x, x coord to put the JButton
     * @param y, y coord to put the JButton
     */
    private void createGrasslandButton(JButton button, int x, int y)
    {
        button.addActionListener((e) -> {
                    Farm farm = gui.getPlayer().purchaseFarm();
                    map.setCell(x, y, farm);
                    gui.update();
                }
        );
    }

    /**
     * Turns a JButton into a JButton to represent a Farm
     *
     * @param button, JButton to turn into a representation of a Farm
     * @param x, x coord to put the JButton
     * @param y, y coord to put the JButton
     */
    private void createFarmButton(JButton button, int x, int y)
    {
        button.addActionListener((e) -> {
            Farm farm = (Farm) map.getCell(x,y);
            gui.setScene(new FarmScene(gui, farm));
        });
    }

}
