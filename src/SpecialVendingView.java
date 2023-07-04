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
     * Displays the interface for when you are inserting cash or buying from a special vending machine.
     * This includes the showing of the customized burger.
     *
     * @param slots refers to the arraylist of slots
     */
    @Override
    public void viewVendingMachine(ArrayList<Slot> slots)
    {
        super.viewVendingMachine(slots);
        System.out.println("-----------------------------------------");
        System.out.println("Customized Items:");
        System.out.printf("[%d] - Burger\n", slots.size());
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
     * Show the details of a customized item.
     *
     * @param burger is the customized object
     */
    public void displayCustomized(Customized burger)
    {
        System.out.println("Customized item:" + Customized.NAME);
        System.out.println("Price: Php " + burger.getPrice());
        System.out.println("Calories: " + burger.getCalories());
    }

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
                components[j].setEnabled(enable); // for the button
                slotIndex++;
            }
        }
    }

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

    @Override
    public void setVendingItemsEnabledForRegularVendingMachine(ArrayList<Slot> slots)
    {
        super.setVendingItemsEnabledForRegularVendingMachine(slots);
        if (customizedSection != null)
        {
            burgerButton.setEnabled(true);
        }
    }

    public void addCustomizedButtonListener(ActionListener listener)
    {
        burgerButton.addActionListener(listener);
    }

    public void addDoneCustomizingListener(ActionListener listener)
    {
        doneCustomized.addActionListener(listener);
    }

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

    public void processDialogListener(ComponentAdapter componentAdapter)
    {
        loading.addComponentListener(componentAdapter);
    }

    public void hiddenFrame(ComponentAdapter componentAdapter)
    {
        this.addComponentListener(componentAdapter);
    }

    public JPanel getCustomizedDetails()
    {
        return customizedDetails;
    }

    public JButton getBurgerButton()
    {
        return burgerButton;
    }

    public JButton getDoneCustomized()
    {
        return  doneCustomized;
    }

    public JDialog getLoading()
    {
        return  loading;
    }


}
