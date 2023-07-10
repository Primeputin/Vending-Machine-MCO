import javax.swing.*;
import java.awt.*;
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



        this.add(main);
        this.add(choose);
        this.setVisible(true);
        this.pack();
    }


    public void addCreateListener(ActionListener listener)
    {
        createVending.addActionListener(listener);
    }

    public void addTestingListener(ActionListener listener)
    {
        testVending.addActionListener(listener);
    }

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
