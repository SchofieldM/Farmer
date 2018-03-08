package main.com.Game.MapObjects;

// Internal Imports
    // GUI
        import main.com.GUI.ImgLinks;
    // Game
        import main.com.Game.Buildings.Building;
        import main.com.Game.Buildings.Field;
        import main.com.Game.Buildings.MainBuilding;

// Java Lang
    import java.util.Random;
    import java.util.ArrayList;

/**
 * Farm to be owned by the player and to be interacted with as the game
 *
 * @author Matthew Schofield
 * @version 1.4.18
 */
public class Farm extends MapObject {

// Fields
    // String
        private String name;
    // ArrayList
        private ArrayList<Building> buildings;
        private ArrayList<Field> fields;
    // Random
        private Random rand;
    // Building
        private Building[][] layout;

// Constructors

    /**
     * Creates a farm with a main building and one field
     *
     * @param name name of the farm
     */
    public Farm(String name)
    {
        super("Farm", ImgLinks.Farm);
        this.name = name;
        this.buildings = new ArrayList<>();
        this.fields = new ArrayList<>();
        Building mainBuilding = new MainBuilding(this);
        this.rand  = new Random();
        this.layout = new Building[6][4];

        build(mainBuilding, 0,0);
        build(new Field(null, "First field"), 1, 0);
    }

// Methods
//void
    /**
     * Plants one of the farm's fields based on its int id with a specified crop
     *
     * @param field, int id of the field to be planted
     * @param seed, String representation of crop to be planted
     */
    public void plantField(Field field, String seed)
    {
        field.plant(seed);
    }

    /**
     * Build a building
     *
     * @param building, building to build
     * @param x, the x coordinate of the building
     * @param y, the y coordinate of the building
     */
    public void build(Building building, int x, int y)
    {
        buildings.add(building);
        if(building.getTypeOfBuilding().equals("Field")){
            fields.add((Field) building);
        }
        layout[x][y] = building;
    }

    /**
     * Renames the farm
     *
     * @param newName, the new name of the farm
     */
    public void setName(String newName)
        {
            name = newName;
        }


    /**
     * Iterates through each Field of the Farm and matures it one cycle, matures the crop
     */
    public void matureFields()
    {
        for(Field field : fields){
            field.mature();
        }
    }

    // Building[][]

    /**
     * Accessor method for the layout of the Farm
     *
     * @return the layout of the Farm
     */
    public Building[][] getLayout()
    {
        return layout;
    }

    //String
    /**
     * Accessor method for the name field
     *
     * @return name field
     */
    public String getName()
    {
        return name;
    }

    /**
     * A String output of the farm's fields
     *
     * @return a String of the farm's fields
     */
    public String listFields()
    {
        String output = "";
        int x = 0;
        for(Building building : buildings){
            if(building.getTypeOfBuilding().equals("Field")){
                output += x + " : " + building.toString() + "\n";
            }
            x++;
        }
        return output;
    }

    /**
     * Outputs a String of the Farm's buildings
     *
     * @return the Farm's buildings
     */
    public String listBuildings()
    {
        String output = "";
        for(Building building : buildings){
            output += building + "\n";
        }
        return output;
    }

    // ArrayList

    /**
     * Accessor method for the buildings ArrayList
     *
     * @return the buildings ArrayList
     */
    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    /**
     * Accessor method for the fields ArrayList
     *
     * @return the fields ArrayList
     */
    public ArrayList<Field> getFields()
    {
        return fields;
    }

    // Field

    /**
     * Gets a random field from the farm
     *
     * @return a random field controlled by the farm
     */
    public Field getARandomField()
    {
        return fields.get(rand.nextInt(fields.size()));
    }

    // Field[]

    /**
     * Accessor method for the fields ArrayList returning in as an array
     *
     * @return fields as an array
     */
    public Field[] getFieldsAsArray()
    {
        Field[] fieldArray = new Field[fields.size()];
        for(int i =0; i < fields.size(); i++){
            fieldArray[i] = fields.get(i);
        }
        return fieldArray;
    }
}
