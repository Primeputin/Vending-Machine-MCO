import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * A class that contains things for displaying related to a special vending machine
 *
 * @author Vladimir Tang
 */
public class SpecialVendingView extends VendingView{

    JPanel customizedSection;
    JPanel customizedDetails;
    JButton burgerButton;
    JButton doneCustomized;
    JDialog loading;
    JLabel loadingTask;

    /**
     * The constructor for this class.
     *
     * @param name is the name of this JFrame
     */
    public SpecialVendingView(String name)
    {
        super(name);
        customizedSection = new JPanel();
        customizedDetails = new JPanel();
        customizedSection.setLayout(new FlowLayout());
        customizedDetails.setLayout(new BorderLayout());
        burgerButton = new JButton("Burger");
        burgerButton.setPreferredSize(new Dimension(100, 100));
        doneCustomized = new JButton("<html>Done<br>Customizing</html>");
        doneCustomized.setPreferredSize(new Dimension(100, 100));
        customizedSection.add(burgerButton);
        customizedSection.add(doneCustomized);
        customizedDetails.add(new JLabel("Php __.__"), BorderLayout.NORTH);
        customizedDetails.add(new JLabel("??? calories"), BorderLayout.SOUTH);
        customizedSection.add(customizedDetails);
        this.add(customizedSection, BorderLayout.SOUTH);
        this.pack();

        loading = new JDialog(this, "Making burger process");
        loadingTask = new JLabel();
        loading.setSize(350, 250);
        loading.add(loadingTask);
        loading.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        loading.setLocationRelativeTo(null);

    }


    /**
     * Showing the process of the burger being made.
     *
     * @param burger is the customized item to display about.
     */
    public void makingBurgerProcess(Customized burger){
        this.setVisible(false);

        Timer timer  = new Timer(1000, new ActionListener() {
            private int i = 0;
            private int j = 0;
            int k = 0;
            private String process = "";
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= burger.getMeats().size() )
                {
                    if (j >= burger.getOthers().size())
                    {
                        if (k == 0)
                        {
                            process = process.concat("Combining the " + burger.getBun().getName() + " with the rest...<br>");
                            loadingTask.setText("<html>" + process + "</html>");
                            k++;
                        }
                        else if (k == 1)
                        {
                            process = process.concat("Burger in your area!\nEnjoy your food!\nBon appétit!\nItadakimasu!!!\nSubarashiiiiiii!!!");
                            loadingTask.setText("<html>" + process + "</html>");
                            loading.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // the setting of hide operation has to be here for some reason
                            ((Timer)e.getSource()).stop();
                        }

                    }
                    else
                    {
                        process = process.concat("Adding " + burger.getOthers().get(j).getName() + "...<br>");
                        loadingTask.setText("<html>" + process + "</html>");
                        j++;
                    }

                }
                else
                {
                    process = process.concat("Cooking " + burger.getMeats().get(i).getName() + "...<br>");
                    loadingTask.setText("<html>" + process + "</html>");
                    i++;

                }
            }
        });

        timer.setRepeats(true);
        timer.start();
        loading.setVisible(true);


    }

    /**
     * This updates the vending items along with its availability status. Thus, it disenable them when necessary at the same time.
     *
     * @param slots refers to the array list of slots and their respective attributes
     */
    public void updateVendingItemsViewWithAvailability(ArrayList <Slot> slots)
    {
        JPanel panel;
        int slotIndex = 0;
        Component[] components;
        boolean enable;
        int j;
        for (Component i: vendingItems.getComponents())
        {
            if (i instanceof JPanel)
            {
                panel = (JPanel) i;
                if (slots.get(slotIndex).getAvailability() <= 0)
                {
                    enable = false;
                }
                else
                {
                    enable = true;
                }
                components = panel.getComponents();

                for (j = 0; j < components.length - 1; j++) // excluding the JButton
                {
                    components[j].setEnabled(enable);

                    if (j == 0)
                    {
                        ((JLabel) components[j]).setText("Php " + slots.get(slotIndex).getPrice());
                    }
                    else if (j == 1)
                    {
                        ((JLabel) components[j]).setText(slots.get(slotIndex).getCalories() + " calories");
                    }
                    else if (j == 2)
                    {
                        ((JLabel) components[j]).setText(slots.get(slotIndex).getIndividual() ? "Solo" : "Not Solo");
                    }
                    else
                    {
                        ((JLabel) components[j]).setText("x" + slots.get(slotIndex).getAvailability());
                    }

                }
                if (!enable)
                {
                    components[j].setEnabled(enable); // for the button
                }
                slotIndex++;
            }
        }
    }

    /**
     * This method updates the display of the vending item and the customized item details.
     *
     * @param slots refers to the array list of slots and their respective attributes
     * @param burger is the customized item
     */
    public void updateSpecialVendingItemsView(ArrayList <Slot> slots, Customized burger)
    {
        updateVendingItemsViewWithAvailability(slots);
        int index = 0;
        for (Component i: customizedDetails.getComponents())
        {
            if (i instanceof  JLabel)
            {
                if (index == 0) // price
                {
                    ((JLabel) i).setText("Php " + burger.getPrice());

                }
                else if (index == 1) // calories
                {
                    ((JLabel) i).setText(burger.getCalories() + " calories");
                }
                index++;
            }
        }

    }

    /**
     * This enables or disenables the vending items buttons along with the customized button.
     *
     * @param enabled is the value whether to enable or disenable the numpads
     */
    @Override
    public void setVendingItemsEnabled(boolean enabled)
    {
        super.setVendingItemsEnabled(enabled);
        if (customizedSection != null) // the if condition is placed here because it would cause NullPointerException at the super constructer method
        {
           burgerButton.setEnabled(enabled);
           doneCustomized.setEnabled(enabled);
        }
    }

    /**
     * his is mostly used when the numpad has selected done. The display will enable all the vending items, including the customized item.
     *
     * @param slots refers to the array list of slots and their respective attributes
     */
    @Override
    public void setVendingItemsEnabledForRegularVendingMachine(ArrayList<Slot> slots)
    {
        super.setVendingItemsEnabledForRegularVendingMachine(slots);
        if (customizedSection != null)
        {
            burgerButton.setEnabled(true);
        }
    }

    /**
     * This adds a functionality for the burger button.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action
     */
    public void addCustomizedButtonListener(ActionListener listener)
    {
        burgerButton.addActionListener(listener);
    }

    /**
     * This adds a functionality for the done customized button.
     *
     * @param listener is the one that listens for something to happens. Afterward, it does a certain action
     */
    public void addDoneCustomizingListener(ActionListener listener)
    {
        doneCustomized.addActionListener(listener);
    }

    /**
     * Sets the only type chosen as enabled in the vending items
     *
     * @param slots refers to the array list of slots and their respective attributes
     * @param type refers to the type of item (bun, meat, or others)
     */
    public void setOnlyTypeEnabled(ArrayList <Slot> slots, int type)
    {
        JPanel panel;
        int slotIndex = 0;
        boolean show;
        for (Component i: vendingItems.getComponents())
        {
            if (i instanceof JPanel)
            {
                panel = (JPanel) i;
                show = slots.get(slotIndex).getType() == type && slots.get(slotIndex).getAvailability() > 0;
                for (Component j: panel.getComponents())
                {

                    if (show)
                    {
                        j.setEnabled(show);
                    }
                    else
                    {
                        j.setEnabled(show);
                    }
                }
                slotIndex++;
            }
        }
    }

    /**
     * This sets all the vending items enables except for the chose type of item.
     *
     * @param slots refers to the array list of slots and their respective attributes
     * @param type refers to the type of item (bun, meat, or others)
     */
    public void setExceptTypeEnabled(ArrayList <Slot> slots, int type)
    {
        JPanel panel;
        int slotIndex = 0;
        boolean show;
        for (Component i: vendingItems.getComponents())
        {
            if (i instanceof JPanel)
            {
                panel = (JPanel) i;
                show = slots.get(slotIndex).getType() != type && slots.get(slotIndex).getAvailability() > 0;
                for (Component j: panel.getComponents())
                {

                    if (show)
                    {
                        j.setEnabled(show);
                    }
                    else
                    {
                        j.setEnabled(show);
                    }

                }
                slotIndex++;
            }
        }
    }

    /**
     * Displays the default for the customized item details.
     */
    public void defaultCustomizedDetails()
    {
        int index = 0;
        for (Component i: customizedDetails.getComponents())
        {
            if (i instanceof JLabel)
            {
                if (index == 0)
                {
                    ((JLabel) i).setText("Php __.__");
                }
                else if (index == 1)
                {
                    ((JLabel) i).setText("??? calories");
                }
                index++;
            }
        }
    }

    /**
     * This does something when something happens to the laoding JDialog component.
     *
     * @param componentAdapter an abstract adapter class for receiving component events
     */
    public void processDialogListener(ComponentAdapter componentAdapter)
    {
        loading.addComponentListener(componentAdapter);
    }

    /**
     * This for resetting the burger when the view's exit button is closed.
     *
     * @param windowAdapter is the thing to wait to what happens to the window
     */
    public void addSpecialVendingExitListener(WindowAdapter windowAdapter)
    {
        this.addWindowListener(windowAdapter);
    }


    /**
     * This method returns the panel containing the labels which contains some detail about the customized item.
     *
     * @return the JPanel customizedDetails
     */
    public JPanel getCustomizedDetails()
    {
        return customizedDetails;
    }

    /**
     * This method returns the burger button.
     *
     * @return the burger button
     */
    public JButton getBurgerButton()
    {
        return burgerButton;
    }

    /**
     * This method returns the done customized button.
     *
     * @return the done customized button
     */
    public JButton getDoneCustomized()
    {
        return  doneCustomized;
    }


}
