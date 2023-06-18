import java.util.LinkedList;

/**
 * This represents a slot in a vending machine.
 * It inherits the attributes and methods of the class Item.
 * It contains the variable availability as an attribute
 * which represents the number of Item instance in a slot machine.
 * The attribute sold represents the number of Item in a slot dispensed or used.
 * As an attribute, the linked list of Items represents the instances of Item in a slot
 * 
 * @author Vladimir Tang
 *
 */
public class Slot extends Item{
	private int availability;
	private int sold;
	private LinkedList<Item> items;
	
	/**
	 * This is constructor method which requires the following parameters
	 * to copy all of its input to its corresponding attribute,
	 * The attributes availability and sold are set to zero by default.
	 * 
	 * @param name is the name of the Item
	 * @param calories is the Item's amount of calories
	 * @param price is the cost of the Item
	 * @param individual True means that it cannot be bought individually
	 */
	public Slot(String name, int calories, int price, boolean individual)
	{
		super(name, calories, price, individual);	
		items = new LinkedList<Item>();
		availability = 0;
		sold = 0;
	}
	/**
	 * This constructor method takes in an Item object as a parameter.
	 * It technically does the same thing as the other constructor method.
	 * 
	 * @param item is an Item instance
	 */
	public Slot(Item item)
	{
		super(item);
		items = new LinkedList<Item>();
		availability = 0;
		sold = 0;
	}
	public void setPrice(int price)
	{
		super.setPrice(price);
		for(int i=0;i<availability;i++)
		{
			items.get(i).setPrice(price);
		}
	}
	/**
	 * This method stocks a number of Item instance in a slot
	 * 
	 * @param num is the number of Item to added in the linked list of Item
	 */
	public void stock(int num)
	{
		for (int i = 0; i < num; i++)
		{
			items.add(new Item(this.getName(), this.getCalories(), this.getPrice(), this.getIndividual()));
			availability++;
		}
	}
	
	/**
	 * Remove the first Item in the linked list and reduce the availability by one.
	 */
	public void destroyItem()
	{
		items.removeFirst();
		sold += 1;
		availability -= 1;
	}

	/**
	 * Clear all items in the slot and set sold and availability back to zero.
	 */
	public void resetItems()
	{
		items.clear();
		sold = 0;
		availability = 0;
	}

	
	/**
	 * Sets the attribute availability to a specific value.
	 * 
	 * @param num will be the value of the attribute availability
	 */
	public void setAvailability(int num)
	{
		this.availability = num;
	}
	
	/**
	 * Sets the attribute sold to a specific value.
	 * 
	 * @param sold will be the value of the attribute sold
	 */
	public void setSold(int sold)
	{
		this.sold = sold;
	}
	
	/**
	 * Sets the attribute items.
	 * @param items will be the linked list of the attribute items
	 */
	public void setItems(LinkedList<Item> items)
	{
		this.items = items;
	}
	
	/**
	 * Returns the attribute availability.
	 * 
	 * @return the attribute availability
	 */
	public int getAvailability()
	{
		return availability;
	}
	
	/**
	 * Returns the attribute sold.
	 * 
	 * @return the attribute sold
	 */
	public int getSold()
	{
		return sold;
	}
	
	/**
	 * Returns the attribute linked list items.
	 * 
	 * @return returns the attribute linked list items
	 */
	public LinkedList<Item> getItems()
	{
		return items;
	}
}
