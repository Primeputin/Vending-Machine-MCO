import java.util.ArrayList;
import java.util.Scanner;

public interface VendingInterface {


        void addSlots(Item item);
        void resetSlots();
        int enterCash(Scanner input);
        int change(int amount, int cost);
        void setAvailableChanges(int[] availableChanges);
        void setAvailableChange(int quantity, int index);
        int[] getAvailableChanges();
        int getAvailableChange(int index);
        ArrayList<Slot> getSlots();
        void viewVendingMachine();


}
