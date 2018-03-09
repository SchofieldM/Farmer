package main.com.GUI;

// Internal Program Imports
    import main.com.Game.Player;

    // ImgLinks Enums
        import static main.com.GUI.ImgLinks.FavIcon;
        import static main.com.GUI.ImgLinks.GameCover;

// Java Lang
    // swing
        import javax.swing.JFrame;
        import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
        import javax.swing.JLabel;
        import javax.swing.WindowConstants;
        import javax.swing.border.LineBorder;
    // awt
        import java.awt.GridBagLayout;
        import java.awt.GridBagConstraints;
        import java.awt.Color;


/**
 * Launcher of the program, a small GUI with a button to launch the GUI of the game
 *
 * @author Matthew Schofield
 * @version 3.7.18
 */
public class Launcher {

// Constants
	// String
		public final static String launcherWindowTitle = "Farmer Launcher";
	
//Fields
    // GridBagConstraints
        private GridBagConstraints constraints;
    // JFrame
        private JFrame mainWindow;
    // JPanel
        private JPanel mainPanel;
        private JPanel contentPanel;
    // JButton
        private JButton newGameButton;
    // JLabel
        private JLabel logoLabel;

// Constructor

    /**
     * Starts the main GUI of the game
     */
    public Launcher()
    {
        createLauncherWindow();
        show();
    }

// Methods

    //void
    /**
     * Shows the launcher
     */
    public void show()
    {
        mainWindow.setVisible(true);
    }

    /**
     * Hides the launcher
     */
	public void hide()
	{
        mainWindow.setVisible(false);
    }

	/**
     * Executes launching the GUI
     */
    public void launchNewGame()
    {
        mainWindow.dispose();
        new GUI(new Player("Matt", 25000));
    }
	
    /**
     * Creates the main window for the launcher
     */
    private void createLauncherWindow()
    {
    	// Create window with proper settings
        mainWindow = new JFrame();
        mainWindow.setTitle(launcherWindowTitle);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setSize(300, 230);
        mainWindow.setIconImage(FavIcon.getImage());
        
        // Sets up GridBagConstraints
        configureGridBagConstraints();
        
        // Add components to the window
        mainWindow.setContentPane(createMainPanel());
        mainPanel.add(createContentPanel());        

        constraints.gridwidth = 2;
        contentPanel.add(createCoverImage(), constraints);
        
        constraints.gridy++;
        contentPanel.add(createGUIButton(), constraints);
    }
    
    /**
     * GridBadConstraints configuration
     */
    private void configureGridBagConstraints()
    {
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;

        // Start points 0,0
        constraints.gridx = 0;
        constraints.gridy = 0;
    }

    // JPanel
    /**
     * Adds the main panel to the window
     */
    private JPanel createMainPanel()
    {
        mainPanel = new JPanel();
        return mainPanel;
    }

    /**
     * Add content pane
     */
    private JPanel createContentPanel()
    {
        contentPanel = new JPanel(new GridBagLayout());

        return contentPanel;
    }

    // JComponent
    /**
     * Add cover
     */
    private JComponent createCoverImage()
    {
        // Creates and scales the game cover art
        int gameCoverWidth = 300;
        int gameCoverHeight = 180;
        logoLabel = GameCover.getScaledLabel(gameCoverWidth, gameCoverHeight);

        // Adds the cover to the window
        return logoLabel;
    }


    /**
     * Adds the button that launches the GUI.GUI
     */
    private JComponent createGUIButton()
    {
        // Construction of the newGame button
        newGameButton = new JButton("New Game!");
        newGameButton.addActionListener(e -> launchNewGame());

        // Styling of play button
        newGameButton.setBackground(new Color(200, 70, 0));
        newGameButton.setBorder(new LineBorder(Color.GREEN));

        
        return newGameButton;
    }

}