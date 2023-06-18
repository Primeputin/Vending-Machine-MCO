import java.util.ArrayList;
import java.util.Scanner;

public class Vending {
	
	private VendingModel vendingModel;
	private VendingView vendingView;
	
	public Vending(VendingModel vendingModel, VendingView vendingView)
	{
		this.vendingModel = vendingModel;
		this.vendingView = vendingView;
	}
	
	public void addSlots(Item item)
	{
		vendingModel.addSlots(item);
	}

	public void resetSlots()
	{
		vendingModel.resetSlots();
	}
	public int enterCash(Scanner input)
	{
		return vendingModel.enterCash(input);
	}
	
	public int change(int amount, int cost)
	{
		return vendingModel.change(amount, cost);
	}
	
	public void setAvailableChanges(int[] availableChanges)
	{
		vendingModel.setAvailableChanges(availableChanges);
	}
	
	public void setAvailableChange(int quantity, int index)
	{
		vendingModel.setAvailableChange(quantity, index);
	}
	
	public int[] getAvailableChanges()
	{
		return vendingModel.getAvailableChanges();
	}
	
	public int getAvailableChange(int index)
	{
		return vendingModel.getAvailableChange(index);
	}
	
	public ArrayList<Slot> getSlots()
	{
		return vendingModel.getSlots();
	}

	public int getDENOMINATION( int index)
	{
		return this.vendingModel.getDENOMINATION(index);
	}
	public void viewVendingMachine()
	{
		vendingView.viewVendingMachine(vendingModel.getSlots());
	}
	public void printReport(){vendingView.printReport(vendingModel.getSlots());}
}
