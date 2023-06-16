
/**
 * This class represents the object of an item in a vending machine.
 * The attribute name represents the name of the Item.
 * The attribute calories represents the amount of calories contained in an Item.
 * The attribute calories represents the cost of the Item.
 * The attribute individual represents if the item can be bought individually or not
 * 
 * @author Vladimir Tang
 *
 */
public class Item {
	
	private String name;
	private int calories;
	private int price;
	private boolean individual;
	int type; // 0 = Others 1= Bun 2= Meat
	
	/**
	 * This constructor method takes in the necessary information that constitute an Item.
	 * 
	 * @param name is the name of the Item
	 * @param calories is the Item's amount of calories
	 * @param price is the cost of the Item
	 * @param individual True means that it cannot be bought individually
	 * @param type is the type of item it is 0 = Others 1= Bun 2= Meat
	 */
	public Item(String name, int calories, int price, boolean individual, int type)
	{
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.individual = individual;
		this.type = type;
	}
	
	/**
	 * This constructor method takes in an Item object as a parameter.
	 * It technically does the same thing as the other constructor method.
	 * 
	 * @param item is an Item instance
	 */
	public Item(Item item)
	{
		this.setName(item.getName());
		this.setCalories(item.getCalories());
		this.setPrice(item.getPrice());
		this.setIndividual(item.getIndividual());
		this.setType(item.getType());
	}
	
	/**
	 * Sets the attribute name.
	 * 
	 * @param name will be the new String value of the attribute name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the attribute calories to a specific value.
	 * 
	 * @param calories will be the new value of the attribute calories
	 */
	public void setCalories(int calories)
	{
		this.calories = calories;
	}
	
	/**
	 * Sets the attribute price to a specific value.
	 * 
	 * @param price will be the new value of the attribute price
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	/**
	 * Sets the attribute individual to either True or False.
	 * 
	 * @param individual will be the new value of the attribute individual
	 */
	public void setIndividual(boolean individual)
	{
		this.individual = individual;
	}

	/**
	 * Sets the attribute type.
	 * 0 = Others 1= Bun 2= Meat
	 *
	 * @param type will be the new value of the attribute type
	 */
	public void setType(int type)
	{
		this.type = type;
	}
	
	/**
	 * Returns the attribute string name.
	 * 
	 * @return the string name attribute
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the attribute calories.
	 * 
	 * @return the attribute calories
	 */
	public int getCalories()
	{
		return calories;
	}
	
	/**
	 * Returns the attribute price.
	 * 
	 * @return the attribute price
	 */
	public int getPrice()
	{
		return price;
	}
	
	/**
	 * Returns the attribute individual,
	 * 
	 * @return the attribute individual
	 */
	public boolean getIndividual()
	{
		return individual;
	}

	/**
	 * Returns the attribute type.
	 * 0 = Others 1= Bun 2= Meat
	 *
	 * @return the attribute type
	 */
	public int getType()
	{
		return this.type;
	}
}
