import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This represents a vending model of the vending machine.
 * It contains an arraylist of the Slot class
 * it also contains an array of integers DENOMINATION as the values of the bills
 * it also contains an array of integers available changes as the number of bills for each denomination the vending machine has
 *
 * @author Vladimir Tang
 *
 */
public class VendingModel {
	
	private ArrayList<Slot> slots = new ArrayList<Slot>(); 
	// one, five, ten, twenty, fifty, one hundred, five hundred php
	private final int[] DENOMINATION = {1, 5, 10, 20, 50, 100, 500};
	private int[] availableChanges = new int[7]; // by default all the values here are zero
	private int cashEntered;

	/**
	 * Is a constructor method meant to instantiate 8 different items for when the vending machine is created.
	 *
	 * @param item1 refers to the first item to be placed in the vending machine
	 * @param item2 refers to the second item to be placed in the vending machine
	 * @param item3 refers to the third item to be placed in the vending machine
	 * @param item4 refers to the fourth item to be placed in the vending machine
	 * @param item5 refers to the fifth item to be placed in the vending machine
	 * @param item6 refers to the sixth item to be placed in the vending machine
	 * @param item7 refers to the seventh item to be placed in the vending machine
	 * @param item8 refers to the eighth item to be placed in the vending machine
	 */
	public VendingModel(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8)
	{
		resetCashEntered();
		addSlots(item1);
		addSlots(item2);
		addSlots(item3);
		addSlots(item4);
		addSlots(item5);
		addSlots(item6);
		addSlots(item7);
		addSlots(item8);

	}

	/**
	 * This method adds an additional slot for a new item to be placed in the vending machine
	 *
	 * @param slot refers to the Slot class
	 */
	public void addSlots(Slot slot)
	{
		slots.add(slot);
	}

	/**
	 * This method adds a new item that is placed in a new slot in the vending machine.
	 *
	 * @param item refers to the Item class which holds the contents of an item to be placed in a vending machine
	 */
	public void addSlots(Item item)
	{
		slots.add(new Slot(item));
	}

	/**
	 * This method resets all the items in every slot.
	 */
	public void resetSlots()
	{
		for (Slot slot: slots)
		{
			slot.resetItems();
			slot.setSale(0);
		}
	}

	/**
	 * This method uses the money given and the price of the item to return the change of the customer.
	 *
	 * @param cost cost of the item being bought
	 * @return the change with respect to the machines ability to give change
	 */
	public int change(int cost)
	{
		int change = cashEntered - cost;
		int[] minusAvailable = new int[7];

		for (int i = availableChanges.length - 1; i >= 1; i--)
		{
			if (change / DENOMINATION[i] <= availableChanges[i] && availableChanges[i] != 0)
			{
				minusAvailable[i] = change / DENOMINATION[i];
				change %= DENOMINATION[i];
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
			change = cashEntered - cost;
			for (int i = 0; i < availableChanges.length; i++)
			{
				availableChanges[i] -= minusAvailable[i];
			}

		}
		return change;
	}

	/**
	 * Resets cash entered to zero.
	 */
	void resetCashEntered()
	{
		cashEntered = 0;
	}


	/**
	 * This method sets the available changes for the denominations.
	 * refers to the object that will take the input of the user in the terminal.
	 *
	 * @param availableChanges is the array of available changes to be set
	 */
	public void setAvailableChanges(int[] availableChanges)
	{
		this.availableChanges = availableChanges;
	}

	/**
	 * Sets the available change to the specific denomination.
	 *
	 * @param quantity refers to how much of the denomination is to be added
	 * @param index refers to the index of which denomination
	 */
	public void setAvailableChange(int quantity, int index)
	{
		availableChanges[index] = quantity;
	}

	/**
	 * Increased cash entered by the amount inserted.
	 *
	 * @param amount is the cash value inserted
	 */
	public void increaseCashEntered(int amount)
	{
		cashEntered += amount;
	}


	/**
	 * This method gets the available change of every denomination.
	 *
	 * @return an array of integers referring to the quantity of the denomination
	 */
	public int[] getAvailableChanges()
	{
		return availableChanges;
	}

	/**
	 * This method gets the available change with respect to which denomnination.
	 *
	 * @param index refers to the index that points to a specific denomination
	 * @return an int at the quantity of the said denomination
	 */
	public int getAvailableChange(int index)
	{
		return availableChanges[index];
	}

	/**
	 * This method gets teh slots of a vending machine.
	 *
	 * @return an arraylist of the slots in the vending machine
	 */
	public ArrayList<Slot> getSlots()
	{
		return slots;
	}

	/**
	 * This method gets which denomination it is refering to based on the index provided.
	 *
	 * @param index refers the which denomination is pointing at
	 * @return an int to the value of the denomination based on the index
	 */
	public int getDENOMINATION(int index)
	{
		return this.DENOMINATION[index];
	}

	/**
	 * Returns cash entered in the vending machine.
	 *
	 * @return the cashEntered attribute
	 */
	public int getCashEntered()
	{
		return cashEntered;
	}

}
