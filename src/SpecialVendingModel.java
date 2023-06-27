/**
 * This represents a vending model of the special vending machine.
 * The burger attribute is the customized item contained in the special vending machine.
 *
 * @author Vladimir Tang
 */
public class SpecialVendingModel extends VendingModel{

    private Customized burger;

    /**
     * Is a constructor method meant to instantiate 8 different items for when the vending machine is created.
     *
     * @param item1 refers to the first item to be placed in the vending machine
     * @param item2 refers to the second item to be placed in the vending machine
     * @param item3 refers to the third item to be placed in the vending machine
     * @param item4 refers to the fourth item to be placed in the vending machine
     * @param item5 refers to the fifth item to be placed in the vending machine
     * @param item6 refers to the sixth item to be placed in the vending machine
     * @param item7 refers to the seventh item to be placed in the vending machine
     * @param item8 refers to the eighth item to be placed in the vending machine
     */
    public SpecialVendingModel(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8)
    {
        super(item1, item2, item3, item4, item5, item6, item7, item8);
    }

    /**
     * This method is for creating a burger.
     *
     * @param bun is the bun for the burger
     * @param meat is the first main meat for the burger
     */
    public void setUpCustomized(Item bun, Item meat)
    {
        burger = new Customized(bun, meat);
    }

    /**
     * Returns the customized object attribute.
     *
     * @return the customized object attribute
     */
    public Customized getBurger() {
        return burger;
    }

    /**
     * Sets the customized object attribute.
     *
     * @param burger is the customized object attribute
     */
    public void setBurger(Customized burger) {
        this.burger = burger;
    }
}
