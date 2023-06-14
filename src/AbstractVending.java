import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractVending{

    abstract void addSlots(Item item);
    abstract void resetSlots();
    abstract int enterCash(Scanner input);
    abstract int change(int amount, int cost);
    abstract void setAvailableChanges(int[] availableChanges);
    abstract void setAvailableChange(int quantity, int index);
    abstract int[] getAvailableChanges();
    abstract int getAvailableChange(int index);
    abstract ArrayList<Slot> getSlots();
    abstract void viewVendingMachine();


}
