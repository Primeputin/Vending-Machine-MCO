import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

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
     *This method calls the method in slots to initiate the vending machine to accept cash.
     *
     * @param input refers to the object that will take the input of the user in the terminal
     * @return the amount for the total cash inserted
     */
    @Override
    public int enterCash(Scanner input)
    {
        return specialVendingModel.enterCash(input);
    }

    /**
     * This method calls the method in the vendingModel class to return the change of a user.
     *
     * @param amount the amount of cash placed in the vending machine
     * @param cost the price of the item bought
     * @return the amount of change to be given to the user
     */
    @Override
    public int change(int amount, int cost)
    {
        return specialVendingModel.change(amount, cost);
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
     * This method refers to the view vending class which is responsible for the printing of various texts for the vending machine when buying or testing the vending machines features.
     */
    @Override
    public void viewVendingMachine()
    {
        specialVendingView.viewVendingMachine(specialVendingModel.getSlots());
    }

    /**
     *This method prints the report to on the sales and stocks depending on the last restocking.
     */
    @Override
    public void printReport(){specialVendingView.printReport(specialVendingModel.getSlots());}

    /**
     * This method is for creating a burger.
     *
     * @param bun is the bun for the burger
     * @param meat is the first main meat for the burger
     */
    public void setUpCustomized(Item bun, Item meat)
    {
        specialVendingModel.setUpCustomized(bun, meat);
    }

    /**
     * Returns the customized object attribute.
     *
     * @return the customized object attribute
     */
    public Customized getBurger() {
        return specialVendingModel.getBurger();
    }

    /**
     * Sets the customized object attribute.
     *
     * @param burger is the customized object attribute
     */
    public void setBurger(Customized burger) {
        specialVendingModel.setBurger(burger);
    }

    /**
     * Showing the process of the burger being made.
     */
    public void makingBurgerProcess()
    {
        specialVendingView.makingBurgerProcess(specialVendingModel.getBurger());
    }

    /**
     * Show the details of a customized item.
     */
    public void displayCustomized()
    {
        specialVendingView.displayCustomized(specialVendingModel.getBurger());
    }

    @Override
    public void setDisplay(boolean show)
    {
        specialVendingView.setVisible(show);

    }

    @Override
    public void addViewingSlot()
    {
        for (Slot i: specialVendingModel.getSlots())
        {
            specialVendingView.addViewingSlot(i.getName(), i.getPrice(), i.getCalories(), i.getIndividual(), i.getAvailability());

        }
    }

    @Override
    public void addMainSourceFrame(MainView mainSourceFrame)
    {
        specialVendingView.addMainSourceFrame(mainSourceFrame);
    }

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
                    JOptionPane.showMessageDialog(null, "Your change is Php " + specialVendingModel.getCashEntered());
                    specialVendingModel.resetCashEntered();
                    specialVendingView.setNumpadsEnabled(true);
                    specialVendingView.setVendingItemsEnabled(false);
                }
                specialVendingView.getCashEntered().setText("Total cash entered: Php " + specialVendingModel.getCashEntered());

            }
        });
    }

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
                        vendingTransaction(i);
                    }
                }
                specialVendingView.setNumpadsEnabled(true);
                specialVendingView.setVendingItemsEnabled(false);
                updateVendingItemsView();
            }
        });

    }

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

    @Override
    public void updateVendingItemsView()
    {
        specialVendingView.updateVendingItemsView(specialVendingModel.getSlots());
    }

    @Override
    public void defaultSettingsView()
    {
        specialVendingView.setNumpadsEnabled(true);
        specialVendingView.setVendingItemsEnabled(false);
        specialVendingModel.resetCashEntered();
        specialVendingView.getCashEntered().setText("Total cash entered: Php " + specialVendingModel.getCashEntered());
    }
}
