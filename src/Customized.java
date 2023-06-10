import java.util.Stack;

public class Customized{
	
	public static final String name = "Burger";
	private int price = 0;
	private int calories = 0;
	private Bun bun;
	private Stack <Meat> meats;
	private Stack <Other> others;
	
	public Customized(Bun bun, Meat meat)
	{
		meats = new Stack <Meat>();
		others = new Stack <Other>();
		
		this.bun = bun;
		price += bun.getPrice();
		calories += bun.getCalories();
		addMeat(meat);
	}
	
	public void addMeat(Meat meat)
	{
		meats.add(meat);
		price += meat.getPrice();
		calories += meat.getCalories();
	}
	
	public void addIngredient(Other ingredient)
	{
		others.add(ingredient);
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
	
	public void setBun(Bun bun)
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
	
	public Bun getBun()
	{
		return bun;
	}
	
	public Stack <Meat> getMeats()
	{
		return meats;
	}
	
	public Stack <Other> getOthers()
	{
		return others;
	}
	
}
