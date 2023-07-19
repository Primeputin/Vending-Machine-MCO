import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class ChangePriceView extends JFrame {
    private JButton bunButton;
    private JButton lettuceButton;
    private JButton tomatoesButton;
    private JButton mozarellaButton;
    private JButton pattyButton;
    private JButton chickenFilletButton;
    private JButton chickenFilletButton1;
    private JButton onionButton;
    private JTextField PriceTextField;
    private JPanel ChangePricePanel;
    private JButton changePriceButton;
    private JLabel PriceLabel;

    public ChangePriceView()
    {
        setContentPane(ChangePricePanel);
        setTitle("Change Price");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addChangePriceExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }
}
