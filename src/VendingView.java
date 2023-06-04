import java.util.ArrayList;

public class VendingView {
	
	public void viewVendingMachine(ArrayList<Slot> slots)
	{
		int i;
		
		for (i = 0; i < slots.size() / 2; i++)
		{
			System.out.printf("[%02d]%-20s", i, slots.get(i).getName());
		}
		
		System.out.println("");
		
		for (i = 0; i < slots.size() / 2; i++)
		{
			System.out.printf("Php %-20d", slots.get(i).getPrice());
		}
		
		System.out.println("");

		for (i = 0; i < slots.size() / 2; i++)
		{
			System.out.printf("%-3d %-20s", slots.get(i).getCalories(), "cal");
		}
		
		System.out.println("");

		for (i = 0; i < slots.size() / 2; i++)
		{
			if (slots.get(i).getIndividual())
			{
				System.out.printf("%-24s", "Solo");

			}
			else
			{
				System.out.printf("%-24s", "Not solo");
			}
		}
		
		System.out.println("");

		for (i = 0; i < slots.size() / 2; i++)
		{
			System.out.printf("x%-23d", slots.get(i).getAvailability());
		}
		
		

		System.out.println("");
		System.out.println("");

		
		
		for (i = slots.size() / 2; i < slots.size(); i++)
		{
			System.out.printf("[%02d]%-20s", i, slots.get(i).getName());
		}
		
		System.out.println("");
		
		for (i = slots.size() / 2; i < slots.size(); i++)
		{
			System.out.printf("Php %-20d", slots.get(i).getPrice());
		}
		
		System.out.println("");

		for (i = slots.size() / 2; i < slots.size(); i++)
		{
			System.out.printf("%-3d %-20s", slots.get(i).getCalories(), "cal");
		}
		
		System.out.println("");

		for (i = slots.size() / 2; i < slots.size(); i++)
		{
			if (slots.get(i).getIndividual())
			{
				System.out.printf("%-24s", "Solo");

			}
			else
			{
				System.out.printf("%-24s", "Not solo");
			}
		}
		
		System.out.println("");

		for (i = slots.size() / 2; i < slots.size(); i++)
		{
			System.out.printf("x%-23d", slots.get(i).getAvailability());
		}
		
		System.out.println("");

	}

}

