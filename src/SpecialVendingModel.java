/**
 * This represents a vending model of the special vending machine.
 * The burger attribute is the customized item contained in the special vending machine.
 *
 * @author Vladimir Tang
 */
public class SpecialVendingModel extends VendingModel{

    private Customized burger;
    private Item bun; // bun here is temporary for the burger
    private Item meat; // meat here is temporary for the burger

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
     */
    public void setUpCustomized()
    {
        burger = new Customized(this.bun, this.meat);
    }

    /**
     * This method is for giving a burger out
     */
    public void giveOutBurger()
    {
        for (Slot i: getSlots())
        {
            while (i.getTempAvailability() > 0)
            {
                i.returnToOriginalAvailability();
            }
        }

        burger = null;
        bun = null;
        meat = null;
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
     * Returns the main bun.
     *
     * @return the bun
     */
    public Item getBun()
    {
        return bun;
    }

    /**
     * Returns the main meat.
     *
     * @return the main meat
     */
    public Item getMeat()
    {
        return meat;
    }

    /**
     * Sets the customized object attribute.
     *
     * @param burger is the customized object attribute
     */
    public void setBurger(Customized burger) {
        this.burger = burger;
    }

    /**
     * Sets the bun.
     *
     * @param bun is the bun attribute
     */
    public void setBun(Item bun)
    {
        this.bun = bun;
    }

    /**
     * Sets the main meat.
     *
     * @param meat is the main meat.
     */
    public void setMeat(Item meat)
    {
        this.meat = meat;
    }


}
