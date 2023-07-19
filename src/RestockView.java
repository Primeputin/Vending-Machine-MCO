import javax.swing.*;

public class RestockView extends JFrame{
    private JButton bunButton;
    private JButton lettuceButton;
    private JButton chickenFilletButton;
    private JButton tomatoesButton;
    private JButton pattyButton;
    private JButton mozarellaButton;
    private JButton fishFilletButton;
    private JButton onionButton;
    private JLabel QuantityLabel;
    private JTextField qty;
    private JPanel ResotckPanel;
    private JButton restockButton;

    public RestockView () {

        setContentPane(ResotckPanel);
        setTitle("Restock");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }
    public static void main (String args[])
    {
        RestockView RestockView = new RestockView();
    }
}
