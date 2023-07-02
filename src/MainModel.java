public class MainModel {

    private Vending vendingMachine;
    private SpecialVending specialVendingMachine;
    private int vendingChoice; // 0 = means none chosen 1 = regular 2 = special

    public MainModel(Vending vendingMachine, SpecialVending specialVendingMachine)
    {
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        vendingChoice = 0;
    }

    public void initializeRegularVending()
    {
        vendingMachine.resetSlots();


        for (int i = 0; i < vendingMachine.getAvailableChanges().length; i++) {
            vendingMachine.setAvailableChange(10, i);

        }
        for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
            vendingMachine.getSlots().get(i).stock(10);

        }
    }

    public void initializeSpecialVending()
    {
        specialVendingMachine.resetSlots();


        for (int i = 0; i < specialVendingMachine.getAvailableChanges().length; i++) {
            specialVendingMachine.setAvailableChange(10, i);

        }
        for (int i = 0; i < specialVendingMachine.getSlots().size(); i++) {
            specialVendingMachine.getSlots().get(i).stock(10);

        }
    }


    public void showRegularVending()
    {
        vendingMachine.viewVendingMachine();
    }

    public void showSpecialVending()
    {
        specialVendingMachine.viewVendingMachine();
    }

    public void regularExist()
    {
        vendingChoice = 1;
    }

    public void specialExist()
    {
        vendingChoice = 2;
    }

    public Vending getVendingMachine()
    {
        return vendingMachine;
    }

    public SpecialVending getSpecialVendingMachine()
    {
        return specialVendingMachine;
    }

    public int getVendingChoice()
    {
        return vendingChoice;
    }

}
