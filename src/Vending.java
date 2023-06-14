import java.util.ArrayList;
import java.util.Scanner;

public class Vending implements VendingInterface{
	
	private VendingModel vendingModel;
	private VendingView vendingView;
	private boolean created = false;

	public Vending(VendingModel vendingModel, VendingView vendingView)
	{
		this.vendingModel = vendingModel;
		this.vendingView = vendingView;
	}
	@Override
	public void addSlots(Item item)
	{
		vendingModel.addSlots(item);
	}

	@Override
	public void resetSlots()
	{
		vendingModel.resetSlots();
	}

	@Override
	public int enterCash(Scanner input)
	{
		return vendingModel.enterCash(input);
	}

	@Override
	public int change(int amount, int cost)
	{
		return vendingModel.change(amount, cost);
	}

	@Override
	public void setAvailableChanges(int[] availableChanges)
	{
		vendingModel.setAvailableChanges(availableChanges);
	}

	@Override
	public void setAvailableChange(int quantity, int index)
	{
		vendingModel.setAvailableChange(quantity, index);
	}

	@Override
	public int[] getAvailableChanges()
	{
		return vendingModel.getAvailableChanges();
	}

	@Override
	public int getAvailableChange(int index)
	{
		return vendingModel.getAvailableChange(index);
	}

	@Override
	public ArrayList<Slot> getSlots()
	{
		return vendingModel.getSlots();
	}
	
	public void viewVendingMachine()
	{
		vendingView.viewVendingMachine(vendingModel.getSlots());
	}
}
