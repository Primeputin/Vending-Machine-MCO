import java.util.ArrayList;

public class Slot extends Item{

	private int availability;
	private ArrayList<Item> items;
	
	public Slot(String name, int calories, int price, boolean individual)
	{
		super(name, calories, price, individual);	
		items = new ArrayList<Item>();
		availability = 0;
	}
	
	public Slot(Item item)
	{
		super(item);
		items = new ArrayList<Item>();
		availability = 0;
	}
	
	public void stock(int num)
	{
		for (int i = 0; i < num; i++)
		{
			items.add(new Item(this.getName(), this.getCalories(), this.getPrice(), this.getIndividual()));
			availability++;
		}
	}
	
	public void destroyItem()
	{
		items.remove(availability - 1);
		availability -= 1;
	}
	
	public void setAvailability(int num)
	{
		this.availability = num;
	}
	
	public void setItems(ArrayList<Item> items)
	{
		this.items = items;
	}
	
	public int getAvailability()
	{
		return availability;
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
}
