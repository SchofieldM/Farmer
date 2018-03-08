package Game;

// Internal Imports
    // Game
        import main.com.Game.Player;
        import main.com.Game.TurnHandler;
// External Imports
    // JUnit
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * To test the TurnHandler class
 */
class TurnHandlerTest {

    // Fields
        // TurnHandler
            private TurnHandler turnHandler;

    /**
     * Create the TurnHandler to test
     */
    @BeforeEach
    void setUp() {
        turnHandler = new TurnHandler(new Player("", 0));
    }

    /**
     * Tests that upon construction that the turn number is 1
     */
    @Test
    @DisplayName("Tests the TurnHandlers getTurnNumber and construction")
    void turnHandlerConstruction() {
        assertEquals(turnHandler.getTurnNumber(), 1);
    }


}