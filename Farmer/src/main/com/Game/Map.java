package main.com.Game;

// Internal imports
    import main.com.Game.MapObjects.Grassland;
    import main.com.Game.MapObjects.MapObject;
    import main.com.Game.MapObjects.Town;

    import java.util.ArrayList;
    import java.util.Random;

/**
 * Map of the game world
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class Map {

    //Fields
        // MapObject
            private MapObject[][] map;

    /**
     * Initializes a map of the game world
     */
    public Map()
    {
        map = new MapObject[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
               map[i][j] = new Grassland();
            }
        }
    }

    /**
     * Changes a specific cell of the map
     *
     * ! add handling for out of bounds !
     *
     * @param width, the xcoord of the cell to change
     * @param height, the ycoord of the cell to change
     * @param mapObj, the new MapObject to store in the cell
     */
    public void setCell(int width, int height, MapObject mapObj)
    {
        map[width][height] = mapObj;
    }

    /**
     * Accessor method for a specific cell on the map
     *
     * @param x, the x coord of the cell
     * @param y, the y coord of the cell
     * @return the MapObj at that cell
     */
    public MapObject getCell(int x, int y) {
        return map[x][y];
    }

    public ArrayList<ArrayList<Integer>> emptyCoords()
    {
        ArrayList<ArrayList<Integer>> cords = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if(map[i][j] instanceof Grassland){
                    ArrayList<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    cords.add(coord);
                }
            }
        }
        return cords;
    }

    public void createATown()
    {
        ArrayList<Integer> cords = emptyCoords().get((new Random()).nextInt(emptyCoords().size()));
        int x = cords.get(0);
        int y = cords.get(1);
        setCell(x,y, new Town());
    }

}
