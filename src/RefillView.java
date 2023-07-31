import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**\
 * This class is for displaying the refill change panel
 */
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

    /**
     * This is the constructor method for refill change
     */
    public RefillView()
    {
        setContentPane(RefillPanel);
        setTitle("Refill Change");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    /**
     * creates a listener for when you exit the panel
     * @param componentAdapter It listens to what will happen to the component state
     */
    public void addRefillExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }
    /**
     * Gets the refill panel and returns it
     * @return the refill panel
     */
    public JPanel getRefillPanel(){return this.RefillPanel;}
    /**
     * Gets the 1 panel and returns it
     * @return the 1 panel
     */
    public JLabel get1label() {return this.label1;}
    /**
     * Gets the 5 panel and returns it
     * @return the 5 panel
     */
    public JLabel get5label() {return this.label5;}
    /**
     * Gets the 10 panel and returns it
     * @return the 10 panel
     */
    public JLabel get10label() {return this.label10;}
    /**
     * Gets the 20 panel and returns it
     * @return the 20 panel
     */
    public JLabel get20label() {return this.label20;}
    /**
     * Gets the 50 panel and returns it
     * @return the 50 panel
     */
    public JLabel get50label() {return this.label50;}
    /**
     * Gets the 100 panel and returns it
     * @return the 100 panel
     */
    public JLabel get100label() {return this.label100;}
    /**
     * Gets the 500 panel and returns it
     * @return the 500 panel
     */
    public JLabel get500label() {return this.label500;}
    /**
     * Gets the a1 button and returns it
     * @return the a1 button
     */

    public JButton getA1Button() {return this.a1Button;}
    /**
     * Gets the a5 button and returns it
     * @return the a5 button
     */
    public JButton getA5Button() {return this.a5Button;}
    /**
     * Gets the a10 button and returns it
     * @return the a10 button
     */
    public JButton getA10Button() {return this.a10Button;}
    /**
     * Gets the a20 button and returns it
     * @return the a20 button
     */
    public JButton getA20Button() {return this.a20Button;}
    /**
     * Gets the a50 button and returns it
     * @return the a50 button
     */
    public JButton getA50Button() {return this.a50Button;}
    /**
     * Gets the a100 button and returns it
     * @return the a100 button
     */
    public JButton getA100Button() {return this.a100Button;}
    /**
     * Gets the a500 button and returns it
     * @return the a500 button
     */
    public JButton getA500Button() {return this.a500Button;}
    /**
     * Creates a listener for all the change buttons
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */

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
