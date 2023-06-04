
public class Item {
	
	private String name;
	private int calories;
	private int price;
	private boolean individual;
	
	public Item(String name, int calories, int price, int availability, boolean individual)
	{
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.individual = individual;
	}
	
	public Item(Item item)
	{
		this.setName(item.getName());
		this.setCalories(item.getCalories());
		this.setPrice(item.getPrice());
		this.setIndividual(item.getIndividual());
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setCalories(int calories)
	{
		this.calories = calories;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setIndividual(boolean individual)
	{
		this.individual = individual;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCalories()
	{
		return calories;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public boolean getIndividual()
	{
		return individual;
	}
	
	
}
