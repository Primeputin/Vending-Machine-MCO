
public class Meat extends Item{
	
	public Meat(String name, int calories, int price, boolean individual)
	{
		super(name, calories, price, individual);
	}
	
	public Meat(Item item)
	{
		super(item);
	}
	
}
