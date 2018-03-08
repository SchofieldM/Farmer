package main.com.Game.Machines;

import main.com.GUI.ImgLinks;
import main.com.Game.Buildings.Field;
import main.com.Game.MapObjects.Farm;
import main.com.Game.Player;

public class Harvester extends Machine {

    public Harvester(Farm farm, Player player)
    {
        super(farm, player, ImgLinks.Harvester);
    }

    @Override
    public void use() {
        for(Field field : farm.getFields()){
            if(field.isReadyToHarvest()) {
                player.harvestField(field);
            }
        }
    }
}
