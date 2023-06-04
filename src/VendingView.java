import java.util.ArrayList;

public class VendingView {
	
	public void viewVendingMachine(ArrayList<Item> items)
	{
		int i;
		
		for (i = 0; i < items.size() / 2; i++)
		{
			System.out.printf("[%02d]%-20s", i, items.get(i).getName());
		}
		
		System.out.println("");
		
		for (i = 0; i < items.size() / 2; i++)
		{
			System.out.printf("Php %-20d", items.get(i).getPrice());
		}
		
		System.out.println("");

		for (i = 0; i < items.size() / 2; i++)
		{
			System.out.printf("%-3d %-20s", items.get(i).getCalories(), "cal");
		}
		
		System.out.println("");

		for (i = 0; i < items.size() / 2; i++)
		{
			if (items.get(i).getIndividual())
			{
				System.out.printf("%-24s", "Solo");

			}
			else
			{
				System.out.printf("%-24s", "Not solo");
			}
		}
		

		System.out.println("");
		System.out.println("");

		
		
		for (i = items.size() / 2; i < items.size(); i++)
		{
			System.out.printf("[%02d]%-20s", i, items.get(i).getName());
		}
		
		System.out.println("");
		
		for (i = items.size() / 2; i < items.size(); i++)
		{
			System.out.printf("Php %-20d", items.get(i).getPrice());
		}
		
		System.out.println("");

		for (i = items.size() / 2; i < items.size(); i++)
		{
			System.out.printf("%-3d %-20s", items.get(i).getCalories(), "cal");
		}
		
		System.out.println("");

		for (i = items.size() / 2; i < items.size(); i++)
		{
			if (items.get(i).getIndividual())
			{
				System.out.printf("%-24s", "Solo");

			}
			else
			{
				System.out.printf("%-24s", "Not solo");
			}
		}
		
		System.out.println("");

	}

}

