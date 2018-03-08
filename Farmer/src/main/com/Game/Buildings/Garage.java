package main.com.Game.Buildings;

import main.com.GUI.ImgLinks;
import main.com.Game.Machines.Harvester;
import main.com.Game.Machines.Machine;
import main.com.Game.MapObjects.Farm;
import main.com.Game.Player;

import java.util.ArrayList;

public class Garage extends Building
{
    // Fields
        // ArrayList
            private Machine[][] machines;
        // Farm
            private Farm farm;

    public Garage(Farm farm, Player player)
    {
        super("Garage", "Garage", ImgLinks.Garage);
        machines = new Machine[2][3];
        machines[0][0] = new Harvester(farm, player);
        this.farm = farm;
    }

    public void addMachine(Machine toAdd, int x, int y)
    {
        machines[y][x] = toAdd;
    }

    public Farm getFarm()
    {
        return farm;
    }

    public Machine[][] getMachines()
    {
        return machines;
    }

}
