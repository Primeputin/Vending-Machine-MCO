import java.util.ArrayList;

public class SpecialVendingView extends VendingView{
    @Override
    public void viewVendingMachine(ArrayList<Slot> slots)
    {
        super.viewVendingMachine(slots);
        System.out.println("-----------------------------------------");
        System.out.println("Customized Items:");
        System.out.printf("[%d] - Burger\n", slots.size());
    }

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
        System.out.println("Burger done!\nEnjoy your food!\n享受你的食物！\nBon appétit!\nSubarashiiiiiii!!!");

    }


}
