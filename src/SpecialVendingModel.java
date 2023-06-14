public class SpecialVendingModel extends VendingModel{

    Customized burger;
    public SpecialVendingModel(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8)
    {
        super(item1, item2, item3, item4, item5, item6, item7, item8);
    }

    public Customized getBurger() {
        return burger;
    }

    public void setBurger(Customized burger) {
        this.burger = burger;
    }
}
