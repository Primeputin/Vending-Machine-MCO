import java.util.ArrayList;

public class SpecialVendingView extends VendingView{
    @Override
    public void viewVendingMachine(ArrayList<Slot> slots)
    {
        super.viewVendingMachine(slots);
        System.out.println("-----------------------------------------");
        System.out.println("Customized Items:");
        System.out.printf("[%d] - Burger\n", slots.size());
    }

}
