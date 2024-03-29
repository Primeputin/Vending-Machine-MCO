import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an abstract class that tells what vending machine's function should have.
 *
 * @author Vladimir Tang
 */
public abstract class AbstractVending{

    /**
     * The default constructor for AbstractVending
     */
    public AbstractVending()
    {

    }

    /**
     * This method adds a new item that is placed in a new slot in the vending machine.
     *
     * @param item refers to the Item class which holds the contents of an item to be placed in a vending machine
     */
    abstract void addSlots(Item item);
    /**
     * This method resets all the items in every slot.
     */
    abstract void resetSlots();

    /**
     * This method sets the available changes for the denominations.
     *
     * @param availableChanges is the array of number of available change for each denomination
     */
    abstract void setAvailableChanges(int[] availableChanges);
    /**
     * Sets the available change to the specific denomination
     * @param quantity refers to how much of the denomination is to be added
     * @param index refers to the index of which denomination
     */
    abstract void setAvailableChange(int quantity, int index);
    /**
     * This method gets the available change of every denomination
     * @return an array of integers referring to the quantity of the denomination
     */
    abstract int[] getAvailableChanges();
    /**
     * This method gets the available change with respect to which denomnination
     * @param index refers to the index that points to a specific denomination
     * @return an in at the quantity of the said denomination
     */
    abstract int getAvailableChange(int index);
    /**
     * This methodc gets teh slots of a vending machine.
     *
     * @return an arraylist of the slots in the vending machine
     */
    abstract ArrayList<Slot> getSlots();
    /**
     * This method gets which denomination it is refering to based on the index provided.
     *
     * @param index refers the which denomination is pointing at
     * @return an int to the value of the denomination based on the index
     */
    abstract int getDENOMINATION(int index);

    /**
     * Sets the display to true or false
     * @param show whether to display or not
     */
    abstract  void setDisplay(boolean show);
/**
 *
 */
    abstract void addViewingSlot();

    abstract void addMainSourceFrame(MainView mainSourceFrame);

    abstract void addDENOMINATIONlistener();

    abstract void addVendingItemsButtonsListener();

    abstract void vendingTransaction(Slot slot);

    abstract void updateVendingItemsView();

    abstract void defaultSettingsView();

    abstract VendingModel getVendingModel();
}
