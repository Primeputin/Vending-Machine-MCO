import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class RestockView extends JFrame{
    private JButton bunButton;
    private JButton lettuceButton;
    private JButton chickenFilletButton;
    private JButton tomatoesButton;
    private JButton pattyButton;
    private JButton mozarellaButton;
    private JButton fishFilletButton;
    private JButton onionButton;
    private JPanel ResotckPanel;
    private JLabel bunlb;
    private JLabel lettucelb;
    private JLabel tomatoeslb;
    private JLabel chicklb;
    private JLabel cheeselb;
    private JLabel pattylb;
    private JLabel onionlb;
    private JLabel fishlb;

    public RestockView () {

        setContentPane(ResotckPanel);
        setTitle("Restock");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addRestockExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }

    public JLabel getBunlb(){return this.bunlb;}
    public JLabel getLettucelb(){return this.lettucelb;};

    public JLabel getCheeselb() {
        return cheeselb;
    }

    public JLabel getChicklb() {
        return chicklb;
    }

    public JLabel getOnionlb() {
        return onionlb;
    }

    public JLabel getFishlb() {
        return fishlb;
    }

    public JLabel getPattylb() {
        return pattylb;
    }

    public JLabel getTomatoeslb() {
        return tomatoeslb;
    }

    public JButton getTomatoesButton() {
        return tomatoesButton;
    }

    public JButton getBunButton() {
        return bunButton;
    }

    public JButton getChickenFilletButton() {
        return chickenFilletButton;
    }

    public JButton getFishFilletButton() {
        return fishFilletButton;
    }

    public JButton getLettuceButton() {
        return lettuceButton;
    }

    public JButton getMozarellaButton() {
        return mozarellaButton;
    }

    public JButton getOnionButton() {
        return onionButton;
    }

    public JButton getPattyButton() {
        return pattyButton;
    }
    public void addRestockButtonListener(ActionListener listener)
    {
        bunButton.addActionListener(listener);
        tomatoesButton.addActionListener(listener);
        onionButton.addActionListener(listener);
        lettuceButton.addActionListener(listener);
        pattyButton.addActionListener(listener);
        chickenFilletButton.addActionListener(listener);
        fishFilletButton.addActionListener(listener);
        mozarellaButton.addActionListener(listener);

    }
}
