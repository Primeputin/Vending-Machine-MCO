import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * This class is for displaying the Restockview
 */
public class RestockView extends JFrame{
    /**
     * Button for the bun.
     */
    private JButton bunButton;
    /**
     * Button for the lettuce.
     */
    private JButton lettuceButton;
    /**
     * Button for the chicken fillet.
     */
    private JButton chickenFilletButton;
    /**
     * Button for the tomatoes.
     */
    private JButton tomatoesButton;
    /**
     * Button for the patty.
     */
    private JButton pattyButton;
    /**
     * Button for the mozarella.
     */
    private JButton mozarellaButton;
    /**
     * Button for the fish fillet.
     */
    private JButton fishFilletButton;
    /**
     * Button for the onion.
     */
    private JButton onionButton;
    /**
     * panel for the whole restocking gui
     */
    private JPanel ResotckPanel;
    /**
     * Label for the bun.
     */
    private JLabel bunlb;
    /**
     * Label for the lettuce.
     */
    private JLabel lettucelb;
    /**
     * Label for the tomatoes.
     */
    private JLabel tomatoeslb;
    /**
     * Label for the chicken fillet.
     */
    private JLabel chicklb;
    /**
     * Label for the mozarella.
     */
    private JLabel cheeselb;
    /**
     * Label for the patty.
     */
    private JLabel pattylb;
    /**
     * Label for the onion.
     */
    private JLabel onionlb;
    /**
     * Label for the fish fillet.
     */
    private JLabel fishlb;

    /**
     * this is the constructor for the restocking class
     */
    public RestockView () {

        setContentPane(ResotckPanel);
        setTitle("Restock");
        setSize(300, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    /**
     * creates a listener for when you exit the panel
     * @param componentAdapter It listens to what will happen to the component state
     */
    public void addRestockExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }
    /**
     * Gets the bun label and returns it
     * @return the bun label
     */
    public JLabel getBunlb(){return this.bunlb;}
    /**
     * Gets the lettuce label and returns it
     * @return the lettuce label
     */
    public JLabel getLettucelb(){return this.lettucelb;}
    /**
     * Gets the cheese label and returns it
     * @return the cheese label
     */

    public JLabel getCheeselb() {
        return cheeselb;
    }
    /**
     * Gets the chicken label and returns it
     * @return the chicken label
     */
    public JLabel getChicklb() {
        return chicklb;
    }
    /**
     * Gets the onion label and returns it
     * @return the onion label
     */
    public JLabel getOnionlb() {
        return onionlb;
    }
    /**
     * Gets the fish label and returns it
     * @return the fish label
     */
    public JLabel getFishlb() {
        return fishlb;
    }
    /**
     * Gets the patty label and returns it
     * @return the patty label
     */
    public JLabel getPattylb() {
        return pattylb;
    }
    /**
     * Gets the tomato label and returns it
     * @return the tomato label
     */
    public JLabel getTomatoeslb() {
        return tomatoeslb;
    }
    /**
     * Gets the tomato button and returns it
     * @return the tomato button
     */
    public JButton getTomatoesButton() {
        return tomatoesButton;
    }
    /**
     * Gets the bun button and returns it
     * @return the bun button
     */
    public JButton getBunButton() {
        return bunButton;
    }
    /**
     * Gets the chicken button and returns it
     * @return the chicken button
     */
    public JButton getChickenFilletButton() {
        return chickenFilletButton;
    }
    /**
     * Gets the fish button and returns it
     * @return the fish button
     */
    public JButton getFishFilletButton() {
        return fishFilletButton;
    }
    /**
     * Gets the lettuce button and returns it
     * @return the lettuce button
     */
    public JButton getLettuceButton() {
        return lettuceButton;
    }
    /**
     * Gets the mozarella button and returns it
     * @return the mozarella button
     */
    public JButton getMozarellaButton() {
        return mozarellaButton;
    }
    /**
     * Gets the onion button and returns it
     * @return the onion button
     */
    public JButton getOnionButton() {
        return onionButton;
    }
    /**
     * Gets the patty button and returns it
     * @return the patty button
     */
    public JButton getPattyButton() {
        return pattyButton;
    }

    /**
     * Adds a listener for every button in restock view
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
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
