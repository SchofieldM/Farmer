package main.com.GUI.Scenes;

// Internal Imports
    // GUI
        import main.com.Game.Buildings.Garage;
        import main.com.Game.MapObjects.Farm;
        import main.com.GUI.GUI;

        // ImgLink enums
            import static main.com.GUI.ImgLinks.EmptyPlot;

    // Game
        import main.com.Game.Player;
        import main.com.Game.Buildings.Building;
        import main.com.Game.Buildings.MainBuilding;
        import main.com.Game.Buildings.Field;

// Java
    // swing
        import javax.swing.JButton;
        import javax.swing.JPanel;
        import javax.swing.JLabel;
        import javax.swing.JOptionPane;
    // awt
        import java.awt.GridBagConstraints;
        import java.awt.GridBagLayout;
        import java.awt.Dimension;

/**
 * Scene to allow the player to interact with a Farm
 *
 * @author Matthew Schofield
 * @version 1.3.18
 */
public class FarmScene extends Scene {

// Fields
    // GUI
        private GUI gui;
    // Player
        private Player player;
    // Farm
        private Farm farm;
    // GridBagConstraints
        private GridBagConstraints constraints;
    // JPanel
        private JPanel buildingPanel;

// Constructors

    /**
     * Creates the scene for a player to interact with a Farm
     *
     * @param gui, GUI that this scene is shown in
     * @param farm, the Farm to be shown in the scene
     */
    public FarmScene(GUI gui, Farm farm)
    {
        super("farmScene");
        this.farm = farm;
        this.gui = gui;
        this.player = gui.getPlayer();
        createFarmPanel();
        createBuildingPanel();
    }

// Methods

    // void

    /**
     * Creates the panel to add components into for the scene
     */
    public void createFarmPanel()
    {
        this.scene = new JPanel();
        configureLayout();
        farmNameText();
    }

    /**
     * Initializes necessities for layout
     */
    private void configureLayout()
    {
        scene.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.weightx = 1;
    }

    /**
     * Creates and adds the text of the Farm name to the GUI
     */
    private void farmNameText()
    {
        JLabel farmName = new JLabel(farm.getName());
        constraints.gridy = 0;
        constraints.gridx = 0;
        scene.add(farmName, constraints);
    }

    /**
     * Creates the panel to add the scene's components
     */
    private void createBuildingPanel()
    {
        buildingPanel = new JPanel();
        buildingPanel.setLayout(new GridBagLayout());
        addBuildingButtons();
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 1;
        scene.add(buildingPanel, constraints);
    }

    /**
     * Adds to the scene the JButton representations of the Farm's buildings
     */
    private void addBuildingButtons()
    {
        short x = 0;
        short y = 0;
        for(int i = 0; i < 24; i++){
            constraints.gridx = x;
            constraints.gridy = y;

            if(farm.getLayout()[x][y] != null) {
                Building building = farm.getLayout()[x][y];

                switch(building.getTypeOfBuilding()){
                    case "Field":
                        buildingPanel.add(createFieldButton((Field) building), constraints);
                        break;
                    case "Main Building":
                        buildingPanel.add(createMainBuildingButton((MainBuilding) building), constraints);
                        break;
                    case "Garage":
                        buildingPanel.add(createGarageButton((Garage) building), constraints);
                        break;
                    default:
                        System.out.println("Error: 005");
                }
            }else{
                buildingPanel.add(createEmptyPlotButton(x, y), constraints);
            }
            x++;
            if (x > 5) {
                x = 0;
                y++;
            }
        }

    }

    /**
     *  For creating JButton representations of empty plots to be added to the scene
     *
     * @param x, the x coord of the empty plot
     * @param y, the y coord of the empty plot
     * @return JButton of an empty plot
     */
    public JButton createEmptyPlotButton(int x, int y)
    {
        JButton emptyPlotButton = new JButton(EmptyPlot.getScaledImageIcon(50, 40));
        emptyPlotButton.setBorderPainted(false);
        emptyPlotButton.addActionListener(e ->
                {
                    String[] options = {"Build Field", "Build Garage"};
                    int choosen = JOptionPane.showOptionDialog(null,
                            "",
                            "",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            EmptyPlot.getScaledImageIcon(40,40),
                            options,
                            options[0]);
                    if(choosen != -1) {
                        if (options[choosen].equals("Build Field")) {

                            player.purchaseField(farm, x, y);

                        }else if(options[choosen].equals("Build Garage")){
                            player.purchaseGarage(farm,x,y);
                        }
                    }
                    gui.update();
                }
        );
        emptyPlotButton.setPreferredSize(new Dimension(50,40));
        return emptyPlotButton;
    }

    /**
     * For creating JButton representation of a Farm's MainBuilding
     *
     * @param mainBuilding, the building to turn into a JButton
     * @return JButton of the given MainBuilding
     */
    public JButton createMainBuildingButton(MainBuilding mainBuilding)
    {
        JButton button = new JButton(mainBuilding.getImgLink().getScaledImageIcon(50, 40));
        button.setPreferredSize(new Dimension(50,40));
        button.addActionListener(e -> {
            String newName = JOptionPane.showInputDialog(null, "New Name: ");
            mainBuilding.renameFarm(newName);
        });
        return button;
    }

    /**
     * Creates a JButton for a field
     *
     * @param field, Field to turn into a JButton
     * @return JButton representation of a Field
     */
    public JButton createFieldButton(Field field)
    {
        String[] seedsToPlant = {"Corn", "Potato"};

        JButton button = new JButton(field.getImgLink().getScaledImageIcon(50, 40));
        button.setPreferredSize(new Dimension(50,40));
        button.setBorderPainted(false);
        button.addActionListener(e ->
                {
                    String cropInfo;
                    if (field.getCrop() != null) {
                        String[] options = {"Harvest", "Clear"};
                        int choosen = JOptionPane.showOptionDialog(null,//parent container of JOptionPane
                                (field).getCropMaturity(),
                                (field).getName(),
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);
                        if(choosen != -1) {
                            if (options[choosen].equals("Harvest")) {
                                player.harvestField(field);
                                gui.update();
                            } else if (options[choosen].equals("Clear")) {
                                (field).clear();
                                gui.update();
                            }
                        }
                    } else {
                        cropInfo = "Empty";
                        String seedToPlant = (String) JOptionPane.showInputDialog(null, cropInfo,
                                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
                                seedsToPlant,
                                seedsToPlant[0]);
                        if(seedToPlant != null) {
                            player.plantField(farm, field, seedToPlant);
                        }
                        gui.update();
                    }
                }
        );
        return button;
    }

    private JButton createGarageButton(Garage garage)
    {
        JButton button = new JButton(garage.getImgLink().getScaledImageIcon(50, 40));
        button.setPreferredSize(new Dimension(50,40));
        button.addActionListener(e -> gui.setScene(new GarageScene(gui, garage)));
        return button;
    }

    // Farm

    /**
     * Accessor method for the Farm this scene displays
     *
     * @return the Farm this scene displays
     */
    public Farm getFarm()
    {
        return farm;
    }

}
