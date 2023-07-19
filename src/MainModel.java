/**
 * This class contains the both the regular vending and special vending machine.
 * It contains the necessary things to do with these machines.
 *
 * @author Vladimir Tang
 */
public class MainModel {

    private Vending vendingMachine;
    private SpecialVending specialVendingMachine;

    private MaintenanceController maintenanceController;
    private int vendingChoice; // 0 = means none chosen 1 = regular 2 = special

    /**
     * Constructor for the main model
     *
     * @param vendingMachine is the regular vending machine
     * @param specialVendingMachine is the special vending machine
     */
    public MainModel(Vending vendingMachine, SpecialVending specialVendingMachine)
    {
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        this.maintenanceController= new MaintenanceController();
        vendingChoice = 0;
    }

    /**
     * Initialization for the regular vending machine.
     */
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

    /**
     * Initialization for the special vending machine.
     */
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

    /**
     * Sets vending choice to 1, meaning regular vending machine is selected
     */
    public void regularExist()
    {
        vendingChoice = 1;
    }

    /**
     * Sets vending choice to 2, meaning special vending machine is selected
     */
    public void specialExist()
    {
        vendingChoice = 2;
    }

    /**
     * Returns the regular vending machine.
     *
     * @return vendingMachine
     */
    public Vending getVendingMachine()
    {
        return vendingMachine;
    }

    /**
     * Returns the special vending machine.
     *
     * @return specialVendingMachine
     */
    public SpecialVending getSpecialVendingMachine()
    {
        return specialVendingMachine;
    }

    /**
     * Returns the vending choice.
     *
     * @return returns the vending choice 0 = none selected 1 = regular vending machine selected 2 = special vending machine selected
     */
    public int getVendingChoice()
    {
        return vendingChoice;
    }

    public MaintenanceController getMaintenanceController() {return maintenanceController;}
}
