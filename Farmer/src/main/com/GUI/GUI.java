package main.com.GUI;

// Internal Program Imports
    // GUI
        // Scenes
            import main.com.GUI.Scenes.*;
            import main.com.Game.Map;
            import main.com.Game.Player;
            import main.com.GUI.Scenes.*;
    // Game

// Java Lang
    // swing
            import javax.swing.*;

/**
 * GUI for the game
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class GUI {

// Fields
    // String
        private SceneName sceneName;
    //Map
        private Map map;
    // Player
        private Player player;
    // Scenes
        private Scene scene;
    // JFrame
        private JFrame mainWindow;
    // JMenuBar
        private JMenuBar menuBar;
    // JMenuItem
        private JMenuItem sleepItem;
        private JMenuItem mapItem;
        private JMenuItem inventoryItem;
        private JMenuItem storeItem;

// Constructors
    /**
     * Constructs and launches the GUI
     *
     * @param player, the player of the game
     */
    public GUI(Player player)
    {
        this.player = player;
        createMainWindow();
        mainWindow.setVisible(true);
        this.map = player.getMap();
        MapScene mapScene = new MapScene(this, map);
        setScene(mapScene);
    }

// Methods

    // Player
    /**
     * Accessor method for the Player of the game using the GUI
     *
     * @return the player
     */
    public Player getPlayer()
    {
        return player;
    }

    // void
    /**
     * Creates the main window and configures it
     */
    private void createMainWindow()
    {
        mainWindow = new JFrame();
        mainWindow.setSize(400, 400);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setTitle("Farmer");
        mainWindow.setIconImage(new ImageIcon(ImgLinks.FavIcon.getURL()).getImage());
        createMenuBar();
    }

    /**
     * Refreshes the scene
     */
    public void update()
    {
        sceneName = scene.getSceneName();
        switch(sceneName){
            case FarmScene:
                setScene(new FarmScene(this, ((FarmScene) scene).getFarm()));
                break;
            case MapScene:
                setScene(new MapScene(this, map));
                break;
            case InventoryScene:
                setScene(new InventoryScene(this));
                break;
            case StoreScene:
                setScene(new StoreScene(this));
                break;
            case GarageScene:
                setScene(new GarageScene(this, ((GarageScene)scene).getGarage()));
                break;
            default:
                throw new RuntimeException("ERROR 002: Unknown Scene");
        }
        updateMenuBar();
    }

    /**
     * Sets the scene of the GUI
     *
     * @param newScene scene to set the GUI to
     */
    public void setScene(Scene newScene)
    {
        mainWindow.setContentPane(newScene.getScene());
        scene = newScene;
        mainWindow.setVisible(true);
    }

    /**
     * Refreshed the GUI's menu bar
     */
    private void updateMenuBar()
    {
        sleepItem.setText("Sleep, Day: " + player.getTurnHandler().getTurnNumber());
        mapItem.setText("Map " + player.getMoney());
        menuBar.setVisible(true);
    }

    /**
     * Creates the menu bar for the GUI
     */
    private void createMenuBar()
    {
        // Creates the MenuBar
        menuBar = new JMenuBar();

        // Creates the MenuItems
        createMapMenuItem();
        createSleepMenuItem();
        createInventoryMenuItem();
        createStoreMenuItem();

        // adds items to the MenuBar
        menuBar.add(mapItem);
        menuBar.add(sleepItem);
        menuBar.add(inventoryItem);
        menuBar.add(storeItem);

        // adds the MenuBar to the window
        mainWindow.setJMenuBar(menuBar);
    }

    /**
     * Creates the mapItem MenuItem
     */
    private void createMapMenuItem()
    {
        mapItem = new JMenuItem("Map " + player.getMoney());
        mapItem.addActionListener(e ->
                {
                    setScene(new MapScene(this, map));
                }
        );
    }

    /**
     * Creates the sleepItem MenuItem
     */
    private void createSleepMenuItem() {
        sleepItem = new JMenuItem("Sleep, Day: " + player.getTurnHandler().getTurnNumber());
        sleepItem.addActionListener(e ->
                {
                    String message = player.sleep();
                    if(!message.equals("Nothing happened")) {
                        JOptionPane.showMessageDialog(null, message);
                    }
                    update();
                }
        );
    }

    /**
     * Creates the inventoryItem MenuItem
     */
    private void createInventoryMenuItem()
    {
        inventoryItem = new JMenuItem("Inventory");
        inventoryItem.addActionListener(e ->
                {
                    setScene(new InventoryScene(this));
                }
        );
    }

    /**
     * Creates the storeItem MenuItem
     */
    private void createStoreMenuItem()
    {
        storeItem = new JMenuItem("Store");
        storeItem.addActionListener(e ->
                {
                    setScene(new StoreScene(this));
                }
        );
    }
}


