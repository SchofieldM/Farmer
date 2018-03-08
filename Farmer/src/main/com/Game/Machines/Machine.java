package main.com.Game.Machines;

import main.com.GUI.ImgLinks;
import main.com.Game.MapObjects.Farm;
import main.com.Game.Player;

import java.awt.*;

public abstract class Machine {

    protected Farm farm;
    protected Player player;
    protected ImgLinks imgLink;


    protected Machine(Farm farm, Player player, ImgLinks imgLink)
    {
        this.farm = farm;
        this.player = player;
        this.imgLink = imgLink;
    }

    /**
     * Accessor method for the imgLink
     *
     * @return imgLink, link to the image file for the machine
     */
    public ImgLinks getImgLink()
    {
        return imgLink;
    }

    public abstract void use();
}
