import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class GetChange extends JFrame {
    private JLabel Amount;
    private JPanel GetChangePanel;

    public GetChange()
    {
        setContentPane(GetChangePanel);
        setTitle("Change Gotten");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void addGetChangeExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }
    public JPanel getGetChangePanel() {
        return this.GetChangePanel;
    }
    public JLabel getAmountLabel(){return this.Amount;}
}
