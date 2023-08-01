import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * This class is for displaying the change price class
 */
public class ChangePriceView extends JFrame {
    /**
     * This button is for the bun's price
     */
    private JButton bunButton;
    /**
     * This button is for the lettuce's price
     */
    private JButton lettuceButton;
    /**
     * This button is for the tomatoes' price
     */
    private JButton tomatoesButton;
    /**
     * This button is for the mozarella's price
     */
    private JButton mozarellaButton;
    /**
     * This button is for the patty's price
     */
    private JButton pattyButton;
    /**
     * This button is for the chicken fillet's price
     */
    private JButton chickenFilletButton;
    /**
     * This button is for the fish fillet's price
     */
    private JButton fishFilletButton;
    /**
     * This button is for the onion's price
     */
    private JButton onionButton;
    /**
     * This textfield is for inputting the price of an item.
     */
    private JTextField PriceTextField;
    /**
     * This JPanel is for the panel of the whole gui.
     */
    private JPanel ChangePricePanel;
    /**
     * This is the button for changing the price of the button.
     */
    private JButton changePriceButton;
    /**
     * This is the label for the price of an item.
     */
    private JLabel PriceLabel;
    /**
     * This is the label for changing price.
     */
    private JLabel priceChangeLb;

    /**
     * This is the constructor for the change price view
     */
    public ChangePriceView()
    {
        setContentPane(ChangePricePanel);
        setTitle("Change Price");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    /**
     * creates a listener for when you exit the panel
     * @param componentAdapter It listens to what will happen to the component state
     */
    public void addChangePriceExit(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }

    /**
     * Gets the ChangePrice panel and returns it
     * @return the Change Price panel
     */
    public JPanel getChangePricePanel() {
        return ChangePricePanel;
    }

    /**
     *  Gets the patty button and returns it
     * @return button
     */
    public JButton getPattyButton() {
        return pattyButton;
    }
    /**
     *  Gets the onion button and returns it
     * @return button
     */
    public JButton getOnionButton() {
        return onionButton;
    }
    /**
     *  Gets the mozarella button and returns it
     * @return button
     */
    public JButton getMozarellaButton() {
        return mozarellaButton;
    }
    /**
     *  Gets the lettuce button and returns it
     * @return button
     */
    public JButton getLettuceButton() {
        return lettuceButton;
    }
    /**
     *  Gets the bun button and returns it
     * @return button
     */
    public JButton getBunButton() {
        return bunButton;
    }
    /**
     *  Gets the chicken fillet button and returns it
     * @return button
     */
    public JButton getChickenFilletButton() {
        return chickenFilletButton;

    }
    /**
     *  Gets the tomato button and returns it
     * @return button
     */
    public JButton getTomatoesButton() {
        return tomatoesButton;
    }
    /**
     *  Gets the change price button and returns it
     * @return button
     */
    public JButton getChangePriceButton() {
        return changePriceButton;
    }
    /**
     *  Gets the fish fillet button and returns it
     * @return button
     */
    public JButton getFishFilletButton()
    {
        return fishFilletButton;
    }
    /**
     *  Gets the price text field and returns it
     * @return price text field
     */
    public JTextField getPriceTextField()
    {
        return PriceTextField;
    }
    /**
     *  Gets the price label and returns it
     * @return price label
     */
    public JLabel getPriceChangeLb() {
        return priceChangeLb;
    }

    /**
     * Creates a listener for all the item buttons
     * @param listener is the one that listens for something to happen. Afterward, it does a certain action when you press a button
     */
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
