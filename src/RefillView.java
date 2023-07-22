import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class RefillView extends JFrame{
    private JButton a1Button;
    private JButton a5Button;
    private JButton a10Button;
    private JButton a100Button;
    private JButton a500Button;
    private JButton a50Button;
    private JButton a20Button;
    private JPanel RefillPanel;
    private JLabel Instructions;
    private JLabel label1;
    private JLabel label5;
    private JLabel label10;
    private JLabel label20;
    private JLabel label50;
    private JLabel label100;
    private JLabel label500;
    private int bill;

    public RefillView()
    {
        setContentPane(RefillPanel);
        setTitle("Refill Change");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addRefillExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }
    public JPanel getRefillPanel(){return this.RefillPanel;}

    public JLabel get1label() {return this.label1;}
    public JLabel get5label() {return this.label5;}
    public JLabel get10label() {return this.label10;}
    public JLabel get20label() {return this.label20;}
    public JLabel get50label() {return this.label50;}
    public JLabel get100label() {return this.label100;}
    public JLabel get500label() {return this.label500;}

    public JButton getA1Button() {return this.a1Button;}
    public JButton getA5Button() {return this.a5Button;}
    public JButton getA10Button() {return this.a10Button;}
    public JButton getA20Button() {return this.a20Button;}
    public JButton getA50Button() {return this.a50Button;}
    public JButton getA100Button() {return this.a100Button;}
    public JButton getA500Button() {return this.a500Button;}

    public void addRefillButtonListener(ActionListener listener)
    {
        a1Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a10Button.addActionListener(listener);
        a20Button.addActionListener(listener);
        a50Button.addActionListener(listener);
        a100Button.addActionListener(listener);
        a500Button.addActionListener(listener);
    }


}
