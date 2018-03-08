package main.com.GUI.Scenes;

// Internal Imports
    // GUI
        import main.com.Game.Player;
        import main.com.GUI.GUI;
    // Game

// Java Lang
    // javax.swing
        import javax.swing.JPanel;
        import javax.swing.JTextArea;

/**
 * InventoryScene to show the Player their inventory
 *
 * @author Matthew Schofield
 * @version 1.16.17
 */
public class InventoryScene extends Scene {

    // Field
        // GUI
            private GUI gui;
        // Player
            private Player player;

    /**
     * Creates the JPanel for the scene
     *
     * @param gui, GUI for the scene to be represented in
     */
    public InventoryScene(GUI gui)
    {
        super("inventoryScene");
        this.gui = gui;
        this.player = gui.getPlayer();
        createInventoryPanel();
    }

    /**
     * Creates the JPanel to represent the scene, the Player's inventory
     */
    public void createInventoryPanel()
    {
        scene = new JPanel();
        JTextArea inventory = new JTextArea();
        inventory.setEditable(false);
        inventory.setText(player.listInventory());
        scene.add(inventory);
    }

}
