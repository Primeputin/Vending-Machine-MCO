import java.util.Stack;

public class Customized{
	
	public static final String name = "Burger";
	private int price = 0;
	private int calories = 0;
	private Item bun;
	private Stack <Item> meats;
	private Stack <Item> others;
	
	public Customized(Item bun, Item meat)
	{
		meats = new Stack <Item>();
		others = new Stack <Item>();
		
		this.bun = bun;
		price += bun.getPrice();
		calories += bun.getCalories();
		addMeat(meat);
	}
	
	public void addMeat(Item meat)
	{
		meats.add(new Item(meat));
		price += meat.getPrice();
		calories += meat.getCalories();
	}
	
	public void addIngredient(Item ingredient)
	{
		others.add(new Item(ingredient));
		price += ingredient.getPrice();
		calories += ingredient.getCalories();
	}
	
	public void setCalories(int calories)
	{
		this.calories = calories;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setBun(Item bun)
	{
		this.bun = bun;
	}
	
	public int getCalories()
	{
		return calories;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public Item getBun()
	{
		return bun;
	}
	
	public Stack <Item> getMeats()
	{
		return meats;
	}
	
	public Stack <Item> getOthers()
	{
		return others;
	}
	
}
