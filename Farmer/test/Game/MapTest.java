package Game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Internal Imports
    import main.com.Game.Map;
import main.com.Game.MapObjects.Farm;
// External Imports
    // JUnit
        import main.com.Game.MapObjects.Grassland;

/**
 * To test the Map class
 */
class MapTest {

    // Fields
        // Map
            private Map map;

    /**
     * Creates a Map to test
     */
    @BeforeEach
    void setUp() {
        map = new Map();
    }

    /**
     * Tests simultaneously the setCell() and getCell() methods
     * With a Farm at 0,0
     */
    @Test
    @DisplayName("setCell() and getCell() test for setting 0,0 to a Farm")
    void setAndGetCell00ToFarm() {
        Farm toHoldInCell = new Farm("");
        map.setCell(0, 0, toHoldInCell);
        assertTrue(map.getCell(0,0).getType().equals("Farm"));
    }

    /**
     * Tests simultaneously the setCell() and getCell() methods
     * With a Grassland at 0,0
     */
    @Test
    @DisplayName("setCell() and getCell() test for setting 0,0 to a Grassland")
    void setAndGetCell00ToGrassland() {
        Grassland toHoldInCell = new Grassland();
        map.setCell(0, 0, toHoldInCell);
        assertTrue(map.getCell(0,0).getType().equals("Grassland"));
    }

    /**
     * Tests simultaneously the setCell() and getCell() methods
     * With a Farm at 2,2
     */
    @Test
    @DisplayName("setCell() and getCell() test for setting 2,2 to a Farm")
    void setAndGetCell22ToFarm() {
        Farm toHoldInCell = new Farm("");
        map.setCell(2, 2, toHoldInCell);
        assertTrue(map.getCell(2,2).getType().equals("Farm"));
    }

    /**
     * Tests simultaneously the setCell() and getCell() methods
     * With a Grassland at 2,2
     */
    @Test
    @DisplayName("setCell() and getCell() test for setting 0,0 to a Grassland")
    void setAndGetCell22ToGrassland() {
        Grassland toHoldInCell = new Grassland();
        map.setCell(2, 2, toHoldInCell);
        assertTrue(map.getCell(2,2).getType().equals("Grassland"));
    }

}