import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class VendingModel {
	
	private ArrayList<Slot> slots = new ArrayList<Slot>(); 
	// one, five, ten, twenty, fifty, one hundred, five hundred php
	private final int[] DENOMINATION = {1, 5, 10, 20, 50, 100, 500};
	private int[] availableChanges = new int[7];
	
	public VendingModel(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8)
	{
		addSlots(item1);
		addSlots(item2);
		addSlots(item3);
		addSlots(item4);
		addSlots(item5);
		addSlots(item6);
		addSlots(item7);
		addSlots(item8);
		
		for (int i = 0; i < availableChanges.length; i++)
		{
			availableChanges[i] = 0;
		}
	}
	
	public void addSlots(Slot slot)
	{
		slots.add(slot);
	}
	
	public void addSlots(Item item)
	{
		slots.add(new Slot(item));
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
				System.out.print("Enter DENOMINATION: ");
				
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
		int[] minusAvailable = new int[7];
		
		for (int i = availableChanges.length - 1; i >= 1; i--)
		{
			if (change / DENOMINATION[i] <= availableChanges[i] && availableChanges[i] != 0)
			{
				change %= DENOMINATION[i];
				minusAvailable[i] = change / DENOMINATION[i];
			}
		}
		
		// for the 1 php
		if (change / DENOMINATION[0] <= availableChanges[0] && availableChanges[0] != 0)
		{
			minusAvailable[0] = change;
			change = 0;
		}
		
		if (change != 0)
		{
			change = -1;
		}
		else
		{
			change = amount - cost;
			for (int i = 0; i < availableChanges.length; i++)
			{
				availableChanges[i] -= minusAvailable[i];
			}		
			
		}
		return change;
	}
	
	public void setAvailableChanges(int[] availableChanges)
	{
		this.availableChanges = availableChanges;
	}
	
	public void setAvailableChange(int quantity, int index)
	{
		availableChanges[index] = quantity;
	}
	
	public int[] getAvailableChanges()
	{
		return availableChanges;
	}
	
	public int getAvailableChange(int index)
	{
		return availableChanges[index];
	}
	
	public ArrayList<Slot> getSlots()
	{
		return slots;
	}
}
