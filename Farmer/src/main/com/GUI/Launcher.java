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
 * @version 1.4.18
 */
public class Launcher {

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
            createMainWindow();
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
             * Creates the main window for the launcher
             */
            private void createMainWindow()
            {
                mainWindow = new JFrame();
                mainWindow.setTitle("Farmer Launcher");
                mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                mainWindow.setResizable(false);
                addMainPanel();
                addContentPanel();
                addCover();
                addGUIButton();
            }

            /**
             * Adds the main panel to the window
             */
            private void addMainPanel()
            {
                mainPanel = new JPanel();
                mainWindow.setSize(300, 230);
                mainWindow.setIconImage(FavIcon.getImage());
                mainWindow.setContentPane(mainPanel);
            }

            /**
             * Add content pane
             */
            private void addContentPanel()
            {
                contentPanel = new JPanel(new GridBagLayout());
                constraints = new GridBagConstraints();
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.weightx = 1;

                mainPanel.add(contentPanel);
            }

            /**
             * Add cover
             */
            private void addCover()
            {
                // Creates and scales the game cover art
                int gameCoverWidth = 300;
                int gameCoverHeight = 180;
                logoLabel = GameCover.getScaledLabel(gameCoverWidth, gameCoverHeight);

                // Adds the cover to the window
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.gridwidth = 2;
                contentPanel.add(logoLabel, constraints);
            }


            /**
             * Adds the button that launches the GUI.GUI
             */
            private void addGUIButton()
            {
                // Construction of the newGame button
                newGameButton = new JButton("New Game!");
                newGameButton.addActionListener(e -> launchNewGame());

                // Styling of play button
                newGameButton.setBackground(new Color(200, 70, 0));
                newGameButton.setBorder(new LineBorder(Color.GREEN));

                // Adding to the panel
                constraints.gridx = 1;
                constraints.gridy = 3;
                contentPanel.add(newGameButton, constraints);
            }

            /**
             * Executes launching the GUI
             */
            public void launchNewGame()
            {
                mainWindow.dispose();
                new GUI(new Player("Matt", 25000));
            }

}