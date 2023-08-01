import java.util.Stack;

/**
 * This Class refers to the customizable options for the special vending machine
 * The attribute name refers to the name oof the product
 * The attribute price is the price of the item
 * The attribute calories is the total calories of the product
 * The attribute bun refers to the Item class
 * The attribute meats refers to the stack of meats
 * The attribute others refers to the stack of other items and condiments
 */
public class Customized{

	/**
	 * name of the burger.
	 */
	public static final String NAME = "Burger";
	private int price = 0;
	private int calories = 0;
	private Item bun;
	private Stack <Item> meats;
	private Stack <Item> others;

	/**
	 * This constructor method instantiates the needed stacks and variables needed for the special vending machine.
	 *
	 * @param bun refers to the item class of bun
	 * @param meat refers to  the item class of meat
	 */
	public Customized(Item bun, Item meat)
	{
		meats = new Stack <Item>();
		others = new Stack <Item>();
		
		this.bun = bun;
		price += bun.getPrice();
		calories += bun.getCalories();
		addMeat(meat);
	}

	/**
	 * This method adds a meat into the stack of meats in the order.
	 *
	 * @param meat refers to the item meat
	 */
	public void addMeat(Item meat)
	{
		meats.add(new Item(meat));
		price += meat.getPrice();
		calories += meat.getCalories();
	}
	/**
	 * This method adds an ingredient into the stack of ingredients in the order.
	 *
	 * @param ingredient refers to the item ingredient
	 */
	public void addIngredient(Item ingredient)
	{
		others.add(new Item(ingredient));
		price += ingredient.getPrice();
		calories += ingredient.getCalories();
	}

	/**
	 * This method sets the calories of the order.
	 *
	 * @param calories refers to the total calories
	 */
	public void setCalories(int calories)
	{
		this.calories = calories;
	}

	/**
	 * This method sets the price of the order.
	 *
	 * @param price refers to the price of the order
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}

	/**
	 * This method changes the bun.
	 *
	 * @param bun refers to the item bun
	 */
	public void setBun(Item bun)
	{
		this.bun = bun;
	}

	/**
	 * This method gets the calories of the order.
	 *
	 * @return the calories of the order
	 */
	public int getCalories()
	{
		return calories;
	}

	/**
	 *This method gets the price of the order.
	 *
	 * @return the price of ther order
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * This method gets the bun.
	 *
	 * @return the item bun
	 */
	public Item getBun()
	{
		return bun;
	}

	/**
	 * This method gets the meat.
	 *
	 * @return the meats stack
	 */
	public Stack <Item> getMeats()
	{
		return meats;
	}

	/**
	 * This method gets the otehr ingredients aside from the meat.
	 *
	 * @return the stack of other ingredients
	 */
	public Stack <Item> getOthers()
	{
		return others;
	}
	
}
