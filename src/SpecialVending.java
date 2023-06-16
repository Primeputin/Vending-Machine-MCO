import java.util.ArrayList;
import java.util.Scanner;

public class SpecialVending extends AbstractVending{

    private SpecialVendingModel specialVendingModel;
    private SpecialVendingView specialVendingView;

    public SpecialVending(SpecialVendingModel specialVendingModel, SpecialVendingView specialVendingView)
    {
        this.specialVendingModel = specialVendingModel;
        this.specialVendingView = specialVendingView;
    }

    @Override
    public void addSlots(Item item)
    {
        specialVendingModel.addSlots(item);
    }

    @Override
    public void resetSlots()
    {
        specialVendingModel.resetSlots();
    }

    @Override
    public int enterCash(Scanner input)
    {
        return specialVendingModel.enterCash(input);
    }

    @Override
    public int change(int amount, int cost)
    {
        return specialVendingModel.change(amount, cost);
    }

    @Override
    public void setAvailableChanges(int[] availableChanges)
    {
        specialVendingModel.setAvailableChanges(availableChanges);
    }

    @Override
    public void setAvailableChange(int quantity, int index)
    {
        specialVendingModel.setAvailableChange(quantity, index);
    }

    @Override
    public int[] getAvailableChanges()
    {
        return specialVendingModel.getAvailableChanges();
    }

    @Override
    public int getAvailableChange(int index)
    {
        return specialVendingModel.getAvailableChange(index);
    }

    @Override
    public ArrayList<Slot> getSlots()
    {
        return specialVendingModel.getSlots();
    }

    @Override
    public void viewVendingMachine()
    {
        specialVendingView.viewVendingMachine(specialVendingModel.getSlots());
    }

    public void setUpCustomized(Item bun, Item meat)
    {
        specialVendingModel.setUpCustomized(bun, meat);
    }

    public Customized getBurger() {
        return specialVendingModel.getBurger();
    }

    public void setBurger(Customized burger) {
        specialVendingModel.setBurger(burger);
    }

}
