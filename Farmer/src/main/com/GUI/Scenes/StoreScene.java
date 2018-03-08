package main.com.GUI.Scenes;

// Internal Program Imports
    import main.com.Game.Player;
    import main.com.GUI.GUI;

// Java Lang
    // javax.swing
        import javax.swing.JPanel;
        import javax.swing.JLabel;
        import javax.swing.JButton;
    // java.awt
        import java.awt.GridBagLayout;
        import java.awt.GridBagConstraints;

/**
 * Scenes to display access to the store
 *
 * @author Matthew Schofield
 * @version 12.31.17
 */
public class StoreScene extends Scene {

    // Fields
        // GUI
            private GUI gui;
        // Player
            private Player player;
        // GridBagConstraints
            private GridBagConstraints constraints;
        // JLabel
            private JLabel seedText;
        // JButton
            private JButton buyCornSeed;
            private JButton buyPotatoSeed;
            private JButton sellAllCrops;

    /**
     *  Creates a store scene for the player to buy and sell goods
     *
     * @param gui the GUI to show the scene in
     */
    public StoreScene(GUI gui)
    {
        super(SceneName.StoreScene);
        this.gui = gui;
        this.player = gui.getPlayer();
        createStorePanel();
    }

    /**
     * Creates the panel to load onto the GUI as the scene
     */
    public void createStorePanel()
    {
        scene = new JPanel();
        scene.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        seedText = new JLabel("Seeds: ");

        constraints.gridx = 0;
        constraints.gridy = 0;

        scene.add(seedText, constraints);

        buyCornSeed = new JButton("Buy Corn Seed");
        buyCornSeed.addActionListener(e ->
                {
                    player.purchaseSeed("Corn", 10);
                    gui.update();
                }
        );
        buyPotatoSeed = new JButton("Buy Potato Seed");
        buyPotatoSeed.addActionListener(e ->
        {
            player.purchaseSeed("Potato", 10);
            gui.update();
        }
        );


        constraints.gridx = 0;
        constraints.gridy = 1;
        scene.add(buyCornSeed, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        scene.add(buyPotatoSeed, constraints);

        sellAllCrops = new JButton("Sell all crops");
        sellAllCrops.addActionListener(e -> {
            player.sellAllGrownCrops();
        });

        constraints.gridx = 0;
        constraints.gridy = 3;

        scene.add(sellAllCrops, constraints);
    }

}
