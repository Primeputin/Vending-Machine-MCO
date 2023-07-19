import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * This interacts with the special vending view class and gives the values for it to print.
 * It also performs various methods that refer to the action of the special vending machine.
 * It inherits the attributes and methods of the AbstractVending class.
 * It contains the variable created as an attribute
 * which represents the boolean if whether the machine is created.
 *
 * @author Vladimir Tang
 *
 */
public class SpecialVending extends AbstractVending{

    private SpecialVendingModel specialVendingModel;
    private SpecialVendingView specialVendingView;

    /**
     *
     * @param specialVendingModel refers to the specialVendingModel object
     * @param specialVendingView refers to the specialVendingView object
     */
    public SpecialVending(SpecialVendingModel specialVendingModel, SpecialVendingView specialVendingView)
    {
        this.specialVendingModel = specialVendingModel;
        this.specialVendingView = specialVendingView;

        addDENOMINATIONlistener();
        addCustomizedButtonListener();
        addDoneCustomizingListener();
        processDialogListener();
        hiddenFrame();
    }

    /**
     * Creates a new slot where a new item will be placed.
     *
     * @param item refers to the item class in which it will be placed in a new slot
     */
    @Override
    public void addSlots(Item item)
    {
        specialVendingModel.addSlots(item);
    }

    /**
     * Clear all items in every slot in the vending machine set sold and availability back to zero.
     */
    @Override
    public void resetSlots()
    {
        specialVendingModel.resetSlots();
    }

    /**
     * This method sets the array of integer for the available changes.
     *
     * @param availableChanges is the array of available changes respective to the vending machines current number of bills
     */
    @Override
    public void setAvailableChanges(int[] availableChanges)
    {
        specialVendingModel.setAvailableChanges(availableChanges);
    }

    /**
     * This method sets the available change of a specific bill or coin.
     *
     * @param quantity the number of bills or coins to be placed
     * @param index to which bill of coin will be added to
     */
    @Override
    public void setAvailableChange(int quantity, int index)
    {
        specialVendingModel.setAvailableChange(quantity, index);
    }

    /**
     * This method returns the array for the available change.
     *
     * @return the array of ints for the number of available change with respect to their value
     */
    @Override
    public int[] getAvailableChanges()
    {
        return specialVendingModel.getAvailableChanges();
    }

    /**
     * This method returns the available change.
     *
     * @param index the index at which bill or coin the vending machine is referring to
     * @return the number of available change based on the index
     */
    @Override
    public int getAvailableChange(int index)
    {
        return specialVendingModel.getAvailableChange(index);
    }

    public void setVendingItemsEnabled(boolean enabled)
    {
        specialVendingView.setVendingItemsEnabled(enabled);
    }

    /**
     * This method returns the slots of the vending machine.
     *
     * @return the array list of slots
     */
    @Override
    public ArrayList<Slot> getSlots()
    {
        return specialVendingModel.getSlots();
    }

    /**
     * This method gets which bill is referred to.
     *
     * @param index the index used to refer to the denomination
     * @return the denomination at which the index is referring to
     */
    @Override
    public int getDENOMINATION(int index)
    {
        return specialVendingModel.getDENOMINATION(index);
    }

    /**
     * This method set whether to show the gui or not.
     *
     * @param show true = show false = do not show
     */
    @Override
    public void setDisplay(boolean show)
    {
        specialVendingView.setVisible(show);

    }

    /**
     * Add vending items from the vending model to show in the GUI.
     */
    @Override
    public void addViewingSlot()
    {
        for (Slot i: specialVendingModel.getSlots())
        {
            specialVendingView.addViewingSlot(i.getName(), i.getPrice(), i.getCalories(), i.getIndividual(), i.getAvailability());

        }
    }

    /**
     * This method adds a mainSourceFrame to the vending view component.
     *
     * @param mainSourceFrame the mainView that came before vendingView
     */
    @Override
    public void addMainSourceFrame(MainView mainSourceFrame)
    {
        specialVendingView.addMainSourceFrame(mainSourceFrame);
    }

    /**
     * This method sets the functionality for the numpads functionality in the GUI.
     */
    @Override
    public void addDENOMINATIONlistener()
    {
        specialVendingView.addDENOMINATIONlistener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == specialVendingView.getOne())
                {
                    specialVendingModel.increaseCashEntered(1);
                }
                else if (e.getSource() == specialVendingView.getFive())
                {
                    specialVendingModel.increaseCashEntered(5);
                }
                else if (e.getSource() == specialVendingView.getTen())
                {
                    specialVendingModel.increaseCashEntered(10);
                }
                else if (e.getSource() == specialVendingView.getTwenty())
                {
                    specialVendingModel.increaseCashEntered(20);
                }
                else if (e.getSource() == specialVendingView.getFifty())
                {
                    specialVendingModel.increaseCashEntered(50);
                }
                else if (e.getSource() == specialVendingView.getOnehundred())
                {
                    specialVendingModel.increaseCashEntered(100);
                }
                else if (e.getSource() == specialVendingView.getFivehundred())
                {
                    specialVendingModel.increaseCashEntered(500);
                }
                else if(e.getSource() == specialVendingView.getDone())
                {
                    specialVendingView.setVendingItemsEnabledForRegularVendingMachine(specialVendingModel.getSlots());
                    specialVendingView.setNumpadsEnabled(false);
                }
                else if (e.getSource() == specialVendingView.getExit())
                {
                    if (!specialVendingView.getBurgerButton().isEnabled())
                    {
                        specialVendingModel.giveOutBurger();
                        updateVendingItemsView();

                    }
                    JOptionPane.showMessageDialog(null, "Your change is Php " + specialVendingModel.getCashEntered());
                    specialVendingModel.resetCashEntered();
                    defaultSettingsView();

                }
                specialVendingView.getCashEntered().setText("Total cash entered: Php " + specialVendingModel.getCashEntered());

            }
        });
    }

    /**
     * This method sets the functionality for the vending items buttons functionality in the GUI.
     */
    @Override
    public void addVendingItemsButtonsListener()
    {
        specialVendingView.addVendingItemsButtonsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Slot i: specialVendingModel.getSlots())
                {
                    if (e.getActionCommand().equals(i.getName()))
                    {
                        if (!specialVendingView.getBurgerButton().isEnabled())
                        {
                            if (i.getType() == 1) // for buns
                            {
                                specialVendingView.setOnlyTypeEnabled(getSlots(), 2); // enabling meat buttons only
                                specialVendingModel.setBun(i.getItems().getFirst());
                                i.onHold();

                            }
                            else if (i.getType() == 2) // for meats
                            {
                                if (specialVendingModel.getBurger() != null) // if burger exists with the required components
                                {
                                    specialVendingModel.getBurger().addMeat(i.getItems().getFirst());
                                    i.onHold();
                                }
                                else if (specialVendingModel.getBun() != null) // meaning bun already picked
                                {
                                    specialVendingModel.setMeat(i.getItems().getFirst());
                                    i.onHold();

                                    specialVendingModel.setUpCustomized();
                                    specialVendingView.setExceptTypeEnabled(getSlots(), 1); // disabling only the buns button
                                    specialVendingView.getDoneCustomized().setEnabled(true);
                                }

                            }
                            else // for other items other than meats and buns
                            {
                                specialVendingModel.getBurger().addIngredient(i.getItems().getFirst());
                                i.onHold();
                            }
                            updateSpecialVendingItemsView();

                        }
                        else
                        {
                            vendingTransaction(i);
                            specialVendingView.setNumpadsEnabled(true);
                            specialVendingView.setVendingItemsEnabled(false);
                            updateVendingItemsView();
                        }
                    }
                }
//
            }
        });

    }

    /**
     * This method does the part for the transaction of the vending machine.
     *
     * @param slot refers to the array list of slots and their respective attributes
     */
    @Override
    public void vendingTransaction(Slot slot)
    {
        int change;

        change = specialVendingModel.change(slot.getPrice());

        if (specialVendingModel.getCashEntered() < slot.getPrice())
        {
            JOptionPane.showMessageDialog(null, "<html>Not enough cash<br>Your change is Php" + specialVendingModel.getCashEntered() + "</html>");
        }
        else if(change == -1)
        {
            JOptionPane.showMessageDialog(null, "<html>Sorry, transaction cannot be made due to insufficient available change<br>Your change is Php" + specialVendingModel.getCashEntered() + "</html>");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Your change is Php " + change);
            slot.destroyItem();
        }

        specialVendingModel.resetCashEntered();

    }

    /**
     * This transaction part of the special vending machine should only be used for transactions regarding a customized item.
     */
    public void vendingCustomizedTransaction()
    {
        int change;

        change = specialVendingModel.change(specialVendingModel.getBurger().getPrice());

        if (specialVendingModel.getCashEntered() < specialVendingModel.getBurger().getPrice())
        {
            JOptionPane.showMessageDialog(null, "<html>Not enough cash<br>Your change is Php" + specialVendingModel.getCashEntered() + "</html>");

        }
        else if(change == -1)
        {
            JOptionPane.showMessageDialog(null, "<html>Sorry, transaction cannot be made due to insufficient available change<br>Your change is Php" + specialVendingModel.getCashEntered() + "</html>");
        }
        else
        {
            specialVendingView.makingBurgerProcess(specialVendingModel.getBurger());
            JOptionPane.showMessageDialog(null, "Your change is Php " + change);
            for (Slot i: specialVendingModel.getSlots())
            {
                while (i.getTempAvailability() > 0)
                {
                    i.useAsIngredient();
                }
            }
        }
        specialVendingModel.giveOutBurger(); // delete the burger
        specialVendingModel.resetCashEntered();

    }

    /**
     * Uses the vendingModel's data to update the display of the vending items in the gui.
     */
    @Override
    public void updateVendingItemsView()
    {
        specialVendingView.updateVendingItemsView(specialVendingModel.getSlots());
    }

    /**
     * Uses the vendingModel's data to update the display of the vending items in the gui (including the customized item).
     */
    public void updateSpecialVendingItemsView()
    {
        int index = 0;
        if (specialVendingModel.getBurger() == null)
        {
            specialVendingView.updateVendingItemsView(getSlots());
            for (Component i: specialVendingView.getCustomizedDetails().getComponents())
            {
                if (i instanceof  JLabel)
                {
                    if (index == 0) // price
                    {
                        ((JLabel) i).setText("Php " + specialVendingModel.getBun().getPrice());

                    }
                    else if (index == 1) // calories
                    {
                        ((JLabel) i).setText(specialVendingModel.getBun().getCalories() + " calories");
                    }
                    index++;
                }
            }
        }
        else
        {
            specialVendingView.updateSpecialVendingItemsView(specialVendingModel.getSlots(), specialVendingModel.getBurger());
        }
    }


    /**
     * Default settings view for the vending machine (cashentered display is taken from the vending model).
     */
    @Override
    public void defaultSettingsView()
    {
        specialVendingView.setNumpadsEnabled(true);
        specialVendingView.setVendingItemsEnabled(false);
        specialVendingModel.resetCashEntered();
        specialVendingView.getCashEntered().setText("Total cash entered: Php " + specialVendingModel.getCashEntered());
        specialVendingView.defaultCustomizedDetails();
    }

    /**
     * This method adds functionality for the customized button.
     */
    public void addCustomizedButtonListener()
    {
        specialVendingView.addCustomizedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialVendingView.getBurgerButton().setEnabled(false);
                specialVendingView.setOnlyTypeEnabled(getSlots(), 1); // enable only the bun
            }
        });
    }

    /**
     * This method adds functionality for the done customizing button.
     */
    public void addDoneCustomizingListener()
    {
        specialVendingView.addDoneCustomizingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (specialVendingModel.getBurger() != null)
                {
                    vendingCustomizedTransaction();
                }
                defaultSettingsView();
                updateVendingItemsView();
            }
        });
    }

    /**
     * When the dialog is closed. The vending view will be visible again.
     */
    public void processDialogListener()
    {
        specialVendingView.processDialogListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                specialVendingView.setVisible(true);
            }
        });
    }

    /**
     * When the vending view becomes invisible, resets the customized item.
     */
    public void hiddenFrame()
    {
        specialVendingView.hiddenFrame(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                specialVendingModel.giveOutBurger();
            }
        });
    }

    public VendingModel getVendingModel() {
        return specialVendingModel;
    }
}
