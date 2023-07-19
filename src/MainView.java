import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is for displaying the main menu.
 *
 * @author Vladimir Tang
 */
public class MainView extends JFrame {

    private JPanel main = new JPanel();
    private JPanel choose = new JPanel();
    private JButton regularChoice = new JButton();
    private JButton specialChoice = new JButton();
    private JButton createVending = new JButton("Create a Vending Machine");
    private JButton testVending = new JButton("Test Vending Machine");
    private JPanel featuresSelection = new JPanel();
    private JButton vendingFeatures = new JButton("Vending Features");
    private JButton maintenanceFeatures = new JButton("Maintenance Features");
    private JButton exitToMainMain = new JButton("Back");

    /**
     * Constructor for this class.
     *
     * @param name is the name for this JFrame
     */
    public MainView(String name)
    {
        this.setTitle(name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350, 300);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(175, 170, 170));
        this.setLocationRelativeTo(null);

        main.setLayout(new BorderLayout());
        main.setSize(200, 200);
        main.add(createVending, BorderLayout.NORTH);

        main.add(testVending, BorderLayout.SOUTH);

        createVending.setFont(new Font("Courier", Font.PLAIN, 15));
        createVending.setMargin(new Insets(10, 25, 10, 25));

        testVending.setFont(new Font("Courier", Font.PLAIN, 15));
        testVending.setMargin(new Insets(10, 25, 10, 25));
        vendingFeatures.setFont(new Font("Courier", Font.PLAIN, 15));
        vendingFeatures.setMargin(new Insets(10, 25, 10, 25));
        maintenanceFeatures.setFont(new Font("Courier", Font.PLAIN, 15));
        maintenanceFeatures.setMargin(new Insets(10, 25, 10, 25));
        exitToMainMain.setFont(new Font("Courier", Font.PLAIN, 15));
        exitToMainMain.setMargin(new Insets(10, 25, 10, 25));
        featuresSelection.setVisible(false);


        testVending.setEnabled(false);
        choose.setVisible(false);

        choose.setLayout(new BorderLayout());
        regularChoice.setText("Regular vending machine");
        regularChoice.setFont(new Font("Courier", Font.PLAIN, 15));
        regularChoice.setMargin(new Insets(10, 25, 10, 25));
        specialChoice.setText("Special vending machine");
        specialChoice.setMargin(new Insets(10, 25, 10, 25));
        specialChoice.setFont(new Font("Courier", Font.PLAIN, 15));
        choose.add(regularChoice, BorderLayout.NORTH);
        choose.add(specialChoice, BorderLayout.SOUTH);

        testVending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                featuresSelection.setVisible(true);
                pack();
            }
        });

        exitToMainMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(true);
                featuresSelection.setVisible(false);
                pack();
            }
        });

        featuresSelection.setLayout(new BorderLayout());
        featuresSelection.add(vendingFeatures, BorderLayout.WEST);
        featuresSelection.add(maintenanceFeatures, BorderLayout.EAST);
        featuresSelection.add(exitToMainMain, BorderLayout.SOUTH);

        this.add(main);
        this.add(choose);
        this.add(featuresSelection);
        this.setVisible(true);
        this.pack();
    }

    /**
     * This creates a action listener when create maintenance features button is clicked.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action for the button
     */
    public void addMaintenanceListener(ActionListener listener){maintenanceFeatures.addActionListener(listener);}

    /**
     * This creates a action listener when create vending button is clicked.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action for the button
     */
    public void addCreateListener(ActionListener listener)
    {
        createVending.addActionListener(listener);
    }

    /**
     * This creates a action listener when vending features button is clicked.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action for the button
     */
    public void addVendingFeaturesListener(ActionListener listener)
    {
        vendingFeatures.addActionListener(listener);
    }

    /**
     * This creates an action listener when either regular vending machine or special vending machine button is clicked.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action for each button
     */
    public void addChoiceListener(ActionListener listener)
    {
        regularChoice.addActionListener(listener);
        specialChoice.addActionListener(listener);
    }

    /**
     * Return the main panel in the JFrame.
     *
     * @return main
     */
    public JPanel getMain()
    {
        return main;
    }

    /**
     * Return the button for testVending.
     *
     * @return testVending
     */
    public JButton getTestVending()
    {
        return testVending;
    }

    /**
     * Return the choose button.
     *
     * @return choose
     */
    public JPanel getChoose()
    {
        return choose;
    }





}
