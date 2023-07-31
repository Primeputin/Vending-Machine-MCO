import javax.swing.*;
import java.awt.event.ComponentAdapter;

/**
 * this class is for displaying the get change panel
 */
public class GetChange extends JFrame {
    private JLabel Amount;
    private JPanel GetChangePanel;

    /**
     * constructor for this class
     */
    public GetChange()
    {
        setContentPane(GetChangePanel);
        setTitle("Change Gotten");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * creates a listener for when you exit the panel
     * @param componentAdapter It listens to what will happen to the component state
     */
    public void addGetChangeExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }

    /**
     *Gets the getChange panel and returns it
     * @return the panel for get change
     */
    public JPanel getGetChangePanel() {
        return this.GetChangePanel;
    }
    /**
     *Gets the amount label and returns it
     * @return the amount label
     */
    public JLabel getAmountLabel(){return this.Amount;}
}
