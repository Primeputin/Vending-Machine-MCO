import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class ChangePriceView extends JFrame {
    private JButton bunButton;
    private JButton lettuceButton;
    private JButton tomatoesButton;
    private JButton mozarellaButton;
    private JButton pattyButton;
    private JButton chickenFilletButton;
    private JButton fishFilletButton;
    private JButton onionButton;
    private JTextField PriceTextField;
    private JPanel ChangePricePanel;
    private JButton changePriceButton;
    private JLabel PriceLabel;
    private JLabel priceChangeLb;

    public ChangePriceView()
    {
        setContentPane(ChangePricePanel);
        setTitle("Change Price");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addChangePriceExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }

    public JPanel getChangePricePanel() {
        return ChangePricePanel;
    }

    public JButton getPattyButton() {
        return pattyButton;
    }

    public JButton getOnionButton() {
        return onionButton;
    }

    public JButton getMozarellaButton() {
        return mozarellaButton;
    }

    public JButton getLettuceButton() {
        return lettuceButton;
    }

    public JButton getBunButton() {
        return bunButton;
    }

    public JButton getChickenFilletButton() {
        return chickenFilletButton;

    }

    public JButton getTomatoesButton() {
        return tomatoesButton;
    }

    public JButton getChangePriceButton() {
        return changePriceButton;
    }
    public JButton getFishFilletButton()
    {
        return fishFilletButton;
    }
    public JTextField getPriceTextField()
    {
        return PriceTextField;
    }

    public JLabel getPriceChangeLb() {
        return priceChangeLb;
    }
    public void addChangePriceButton(ActionListener listener)
    {
        tomatoesButton.addActionListener(listener);
        fishFilletButton.addActionListener(listener);
        changePriceButton.addActionListener(listener);
        chickenFilletButton.addActionListener(listener);
        bunButton.addActionListener(listener);
        lettuceButton.addActionListener(listener);
        pattyButton.addActionListener(listener);
        mozarellaButton.addActionListener(listener);
        onionButton.addActionListener(listener);

    }
}
