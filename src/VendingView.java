import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class that contains things for displaying related to a regular vending machine
 *
 * @author Vladimir Tang
 */
public class VendingView extends JFrame {


	public VendingView(String name)
	{
		this.setTitle("Regular vending machine");
		this.setTitle(name);
		this.setLayout(new FlowLayout());
	}


	/**
	 * Displays the interface for when you are inserting cash or buying from a vending machine.
	 *
	 * @param slots refers to the arraylist of slots
	 */
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

	/**
	 * Prints the summary of sales and current stock, respective to the previous restocking
	 *
	 * @param slots refers to the array list of slots and their respective attributes
	 */
	public void printReport(ArrayList<Slot> slots)
	{
		int total=0;
		System.out.println("============================================");
		System.out.printf("%24s","Number of sold items\n");
		for (int i=0; i<slots.size(); i++)
		{
			System.out.printf("%-15s| %d item/s sold\n", slots.get(i).getName(), slots.get(i).getSold());
		}
		System.out.println("============================================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("==================================================================");
		System.out.printf("%24s","Number of sales per item\n");
		System.out.println("==================================================================");
		System.out.printf("%-15s|\tPrevious stock\tCurrent stock\tSales\n","Item");
		System.out.println("==================================================================");
		for (int i=0; i<slots.size(); i++)
		{
			total = total + slots.get(i).getSale();
			System.out.printf("%-15s|\t%8d\t%8d\t%4d Php\n",slots.get(i).getName(),slots.get(i).getAvailability()+slots.get(i).getSold(),slots.get(i).getAvailability(),slots.get(i).getSale());
		}
		System.out.println("__________________________________________________________________\n");
		System.out.printf("Total Sales: %d Php\n", total);
		System.out.println("==================================================================\n\n\n");

	}

}

