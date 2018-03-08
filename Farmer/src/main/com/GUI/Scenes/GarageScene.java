package main.com.GUI.Scenes;

// Internal imports
    // GUI
        import main.com.GUI.GUI;
        import main.com.GUI.ImgLinks;
    // Game
        import main.com.Game.Buildings.Garage;
        import main.com.Game.Machines.Harvester;
        import main.com.Game.Machines.Machine;
        import main.com.Game.Machines.Planter;
        import main.com.Game.MapObjects.Farm;
        import main.com.Game.Player;

// java lang
    import javax.swing.*;
    import java.awt.*;

/**
 * To allow interaction with Garage's
 *
 * @author Matthew Schofield
 * @version 1.17.18
 */
public class GarageScene extends Scene{

    // Fields
        // Garage
            private Garage garage;
        // Player
            private Player player;
        //GUI
            private GUI gui;
        // GridBagConstraints
            private GridBagConstraints constraints;
        // Farm
            private Farm farm;

    public GarageScene(GUI gui, Garage garage)
    {
        super("garageScene");
        this.gui = gui;
        this.player = gui.getPlayer();
        this.farm = garage.getFarm();
        this.garage = garage;
        createGaragePanel();
    }

    public Garage getGarage()
    {
        return garage;
    }
    /**
     * Initializes necessities for layout
     */
    private void configureLayout()
    {
        scene.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        //constraints.weightx = 1;
    }
    public void createGaragePanel()
    {
        scene = new JPanel();
        configureLayout();
        int x = 0;
        int y = 0;
        for(Machine[] row : garage.getMachines())
        {
            for(Machine machine : row){
                constraints.gridx = x;
                constraints.gridy = y;
                if(machine != null)
                    scene.add(makeButtonOfMachine(machine), constraints);
                else{
                    scene.add(makeEmptySlotButton(x,y), constraints);
                }
                x++;
            }
            x=0;
            y++;
        }
    }

    public JButton makeButtonOfMachine(Machine machine)
    {
        JButton button = new JButton(machine.getImgLink().getScaledImageIcon(80,60));
        button.addActionListener(e ->
        {
            machine.use();
            gui.update();
        });
        return button;
    }

    public JButton makeEmptySlotButton(int x, int y)
    {
        JButton button = new JButton(ImgLinks.GarageFloor.getScaledImageIcon(80,60));
        button.addActionListener(e ->
            {
                showChoiceForMachine(x, y);
                gui.update();
            }
        );
        return button;
    }

    public void showChoiceForMachine(int x, int y)
    {
        String[] machineChoices = new String[]{"Harvester", "Planter"};
        String machineChoice = (String) JOptionPane.showInputDialog(null, "",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
                machineChoices,
                machineChoices[0]);
        switch (machineChoice){
            case "Harvester":
                garage.addMachine(new Harvester(farm, player), x, y);
                break;
            case "Planter":
                garage.addMachine(new Planter(farm, player), x, y);
                break;
        }
        player.purchaseMachine(machineChoice);
    }
}
