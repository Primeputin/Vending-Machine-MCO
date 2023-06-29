import java.util.ArrayList;

/**
 * A class that contains things for displaying related to a special vending machine
 *
 * @author Vladimir Tang
 */
public class SpecialVendingView extends VendingView{
    /**
     * Displays the interface for when you are inserting cash or buying from a special vending machine.
     * This includes the showing of the customized burger.
     *
     * @param slots refers to the arraylist of slots
     */
    @Override
    public void viewVendingMachine(ArrayList<Slot> slots)
    {
        super.viewVendingMachine(slots);
        System.out.println("-----------------------------------------");
        System.out.println("Customized Items:");
        System.out.printf("[%d] - Burger\n", slots.size());
    }

    /**
     * Showing the process of the burger being made.
     *
     * @param burger is the customized item to display about.
     */
    public void makingBurgerProcess(Customized burger)
    {
        int i;
        for (i = 0; i < burger.getMeats().size(); i++)
        {
            System.out.println("Cooking " + burger.getMeats().get(i).getName() + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (i = 0; i < burger.getOthers().size(); i++)
        {
            System.out.println("Adding " + burger.getOthers().get(i).getName() + "...");
            try {
                Thread.sleep(550);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Combining the " + burger.getBun().getName() + " with the rest...");
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Burger in your area!\nEnjoy your food!\nBon appétit!\nItadakimasu!!!\nSubarashiiiiiii!!!");

    }

    /**
     * Show the details of a customized item.
     *
     * @param burger is the customized object
     */
    public void displayCustomized(Customized burger)
    {
        System.out.println("Customized item:" + Customized.name);
        System.out.println("Price: Php " + burger.getPrice());
        System.out.println("Calories: " + burger.getCalories());
    }



}
