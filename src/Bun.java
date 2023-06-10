
public class Bun extends Item{

	public Bun(String name, int calories, int price, boolean individual)
	{
		super(name, calories, price, individual);
	}
	
	public Bun(Item item)
	{
		super(item);
	}
}
