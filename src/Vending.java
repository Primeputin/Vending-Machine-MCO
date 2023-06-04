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
	
	public int enterCash(Scanner input)
	{
		return vendingModel.enterCash(input);
	}
	
	public int change(int amount, int cost)
	{
		return vendingModel.change(amount, cost);
	}
	
	public void setOne(int num)
	{
		vendingModel.setOne(num);
	}
	
	public void setFive(int num)
	{
		vendingModel.setFive(num);
	}
	
	public void setTen(int num)
	{
		vendingModel.setTen(num);
	}
	
	public void setTwenty(int num)
	{
		vendingModel.setTwenty(num);
	}
	
	public void setFifty(int num)
	{
		vendingModel.setFifty(num);
	}
	
	public void setOneHundred(int num)
	{
		vendingModel.setOneHundred(num);
	}
	
	public void setFiveHundred(int num)
	{
		vendingModel.setFiveHundred(num);
	}
	
	public int getOne()
	{
		return vendingModel.getOne();
	}
	
	public int getFive()
	{
		return vendingModel.getOne();
	}
	
	public int getTen()
	{
		return vendingModel.getTen();
	}
	
	public int getTwenty()
	{
		return vendingModel.getTwenty();
	}
	
	public int getFifty()
	{
		return vendingModel.getFifty();
	}
	
	public int getOneHundred()
	{
		return vendingModel.getOneHundred();
	}
	
	public int getFiveHundred()
	{
		return vendingModel.getFiveHundred();
	}
	
	public ArrayList<Slot> getSlots()
	{
		return vendingModel.getSlots();
	}
	
	public void viewVendingMachine()
	{
		vendingView.viewVendingMachine(vendingModel.getSlots());
	}
}
