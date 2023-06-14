import java.util.ArrayList;

public class SpecialVendingView extends VendingView{
    @Override
    public void viewVendingMachine(ArrayList<Slot> slots)
    {
        System.out.println("Customized Items:");
        System.out.println("[100] - Burger\n-----------------------------------------");
        super.viewVendingMachine(slots);
    }

}
