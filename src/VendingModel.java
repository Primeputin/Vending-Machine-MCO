import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class VendingModel {
	
	private ArrayList<ArrayList<Item>> slots = new ArrayList<ArrayList<Item>>(); // 2D array of items in the vending machine
	private ArrayList<Item> items = new ArrayList<Item>(); // list of menu in the vending machine
	private int one;
	private int five;
	private int ten;
	private int twenty;
	private int fifty;
	private int onehundred;
	private int fivehundred;
	
	public void addSlots(Item item)
	{
		ArrayList<Item> newItem = new ArrayList<Item>();
		items.add(item); // add to the list of menu in the vending machine
		slots.add(newItem);
	}
	
	public void stock(int slotIndex, int num)
	{
		for (int i = 0; i < num; i++)
		{
			Item stock = new Item(items.get(slotIndex));
			slots.get(slotIndex).add(stock);
		}
	}
	
	public int enterCash(Scanner input)
	{
		int amount = 0;
		int choice;
		boolean exit = false;

		try {
			while(!exit)
			{
				System.out.println("TOTAL CASH INSERTED: " + amount);
				System.out.println("[0] - Php 1 [1] - Php 5 [2] - Php 10");
				System.out.println("[3] - Php 20 [4] - Php 50 [5] - Php 100");
				System.out.println("[6] - Php 500 [7] - EXIT");
				System.out.print("Enter denomination: ");
				
				choice = input.nextInt();
				
				switch(choice)
				{
					case 0:
						amount += 1;
						break;
					case 1:
						amount += 5;
						break;
					case 2:
						amount += 10;
						break;
					case 3:
						amount += 20;
						break;
					case 4:
						amount += 50;
						break;
					case 5:
						amount += 100;
						break;
					case 6:
						amount += 500;
						break;
					case 7:
						exit = true;
						break;
					default:
						System.out.println("Wrong input!!!");
				}
				
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Input error");
			e.printStackTrace();
		}
		
		return amount;
		
		
	}
	
	public int change(int amount, int cost)
	{
		int change = amount - cost;
		int minusfivehundred = 0;
		int minusonehundred = 0;
		int minusfifty = 0;
		int minustwenty = 0;
		int minusten = 0;
		int minusfive = 0;
		int minusone = 0;
		
		if (change / 500 <= fivehundred && fivehundred != 0)
		{
			change %= 500;
			minusfivehundred = change / 500;
		}
		if (change / 100 <= onehundred && onehundred != 0)
		{
			change %= 100;
			minusonehundred = change / 100;
		}
		if (change / 50 <= fifty && fifty != 0)
		{
			change %= 50;
			minusfifty = change / 50;
		}
		if (change / 20 <= twenty && twenty != 0)
		{
			change %= 20;
			minustwenty = change / 20;
		}
		if (change / 10 <= ten && ten != 0)
		{
			change %= 10;
			minusten = change / 10;
		}
		if (change / 5 <= five && five != 0)
		{
			change %= 5;
			minusfive = change / 5;
		}
		if (change / 1 <= one && one != 0)
		{
			minusone = change;
			change = 0;
		}
		
		if (change != 0)
		{
			change = -1;
		}
		else
		{
			change = amount - cost;
			fivehundred -= minusfivehundred;
			onehundred -= minusonehundred;
			fifty -= minusfifty;
			twenty -= minustwenty;
			ten -= minusten;
			five -= minusfive;
			one -= minusone;
			
		}
		return change;
	}
	
	public void setOne(int num)
	{
		one = num;
	}
	
	public void setFive(int num)
	{
		five = num;
	}
	
	public void setTen(int num)
	{
		ten = num;
	}
	
	public void setTwenty(int num)
	{
		twenty = num;
	}
	
	public void setFifty(int num)
	{
		fifty = num;
	}
	
	public void setOneHundred(int num)
	{
		onehundred = num;
	}
	
	public void setFiveHundred(int num)
	{
		fivehundred = num;
	}
	
	public int getOne()
	{
		return one;
	}
	
	public int getFive()
	{
		return five;
	}
	
	public int getTen()
	{
		return ten;
	}
	
	public int getTwenty()
	{
		return twenty;
	}
	
	public int getFifty()
	{
		return fifty;
	}
	
	public int getOneHundred()
	{
		return onehundred;
	}
	
	public int getFiveHundred()
	{
		return fivehundred;
	}
	
	public ArrayList<ArrayList<Item>> getSlots()
	{
		return slots;
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
}
