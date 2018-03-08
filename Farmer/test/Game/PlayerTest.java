package Game;

// Internal imports
    // Game
        import main.com.Game.Player;

// External imports
    // JUnit
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Player class
 */
class PlayerTest {

    // Field
        // Player
            Player player;

    /**
     * Sets up a Player object with construction Player(String, int) to be tested
     */
    @BeforeEach
    void setUp() {
        player = new Player("Matthew", 25000);
    }

    /**
     * Tests the construction of Player(String, int) with expected data for name in
     */
    @Test
    @DisplayName("Tests construction of Player(String, int) with expected String data")
    void testsPlayerStringIntConstructionWithExpectedName()
    {
        assertEquals(player.getName(), "Matthew");
    }

    /**
     * Tests the construction of Player(String, int) with expected data for money
     */
    @Test
    @DisplayName("Tests construction of Player(String, int) with expected int data")
    void testsPlayerStringIntConstructionWithExpectedMoney()
    {
        assertEquals(player.getMoney(), 25000);
    }

    /**
     * Tests the construction of Player(String, int) with improper data for money in -1
     */
    @Test
    @DisplayName("Tests construction of Player(String, int) with unexpected int data in -1")
    void testsPlayerStringIntConstructionWithNegativeMoney()
    {
        Player playerWithNegativeMoney = new Player("Matthew", -1);
        assertEquals(playerWithNegativeMoney.getMoney(), 0);
    }

    /**
     * Tests the construction of Player(String, int) with 0 for money
     */
    @Test
    @DisplayName("Tests construction of Player(String, int) with int data of 0")
    void testsPlayerStringIntConstructionWith0Money()
    {
        Player playerWithNegativeMoney = new Player("Matthew", 0);
        assertEquals(playerWithNegativeMoney.getMoney(), 0);
    }

    /**
     *
     */
}