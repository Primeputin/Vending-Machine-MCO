import java.util.LinkedList;

public class Slot extends Item{

	private int availability;
	private int sold;
	private LinkedList<Item> items;
	
	public Slot(String name, int calories, int price, boolean individual)
	{
		super(name, calories, price, individual);	
		items = new LinkedList<Item>();
		availability = 0;
		sold = 0;
	}
	
	public Slot(Item item)
	{
		super(item);
		items = new LinkedList<Item>();
		availability = 0;
		sold = 0;
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
		items.removeFirst();
		availability -= 1;
	}
	
	public void setAvailability(int num)
	{
		this.availability = num;
	}
	
	public void setSold(int sold)
	{
		this.sold = sold;
	}
	
	public void setItems(LinkedList<Item> items)
	{
		this.items = items;
	}
	
	public int getAvailability()
	{
		return availability;
	}
	
	public int getSold()
	{
		return sold;
	}
	
	public LinkedList<Item> getItems()
	{
		return items;
	}
}
