package main.com.Game.Machines;

// Internal Imports
    // GUI
        import main.com.GUI.ImgLinks;
    // Game
        import main.com.Game.Buildings.Field;
        import main.com.Game.MapObjects.Farm;
        import main.com.Game.Player;
// External Imports
    import javax.swing.JOptionPane;

public class Planter extends Machine{

    public Planter(Farm farm, Player player)
    {
        super(farm, player, ImgLinks.Planter);
    }

    @Override
    public void use()
    {
        System.out.print(farm.getName());
        String[] seedsToPlant = {"Corn", "Potato"};
        String seedToPlant = (String) JOptionPane.showInputDialog(null, "",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
                seedsToPlant,
                seedsToPlant[0]);
        if(seedToPlant != null) {
            for(Field field : farm.getFields()) {
                player.plantField(farm, field, seedToPlant);
            }
        }
    }

}
