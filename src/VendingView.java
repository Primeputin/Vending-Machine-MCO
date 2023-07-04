import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * A class that contains things for displaying related to a regular vending machine
 *
 * @author Vladimir Tang
 */
public class VendingView extends JFrame {

	MainView mainSourceFrame;
	JPanel vendingItems;
    JPanel numpads;
	JPanel rightSide;
	JLabel cashEntered;
	JLabel entry;
	JButton one;
	JButton five;
	JButton ten;
	JButton twenty;
	JButton fifty;
	JButton onehundred;
	JButton fivehundred;
	JButton done;
	JButton exit;
	public VendingView(String name)
	{
		init(name);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (mainSourceFrame != null)
				{
					mainSourceFrame.setVisible(true);
				}
				super.windowClosing(e);
			}
		});
	}

	public void addMainSourceFrame(MainView mainSourceFrame)
	{
		this.mainSourceFrame = mainSourceFrame;
	}


	public void init(String name)
	{
		this.setTitle("Regular vending machine");
		this.setTitle(name);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		vendingItems = new JPanel(new GridLayout(4, 4));

		rightSide = new JPanel(new BorderLayout());
		cashEntered = new JLabel("Total cash entered: Php 0.00");

		numpads = new JPanel();
		numpads.setLayout(new GridLayout(3, 3));

		one = new JButton("Php 1");
		five = new JButton("Php 5");
		ten = new JButton("Php 10");
		twenty = new JButton("Php 20");
		fifty = new JButton("Php 50");
		onehundred = new JButton("Php 100");
		fivehundred = new JButton("Php 500");
		done = new JButton("Done");
		exit = new JButton("X");

		numpads.add(one);
		numpads.add(five);
		numpads.add(ten);
		numpads.add(twenty);
		numpads.add(fifty);
		numpads.add(onehundred);
		numpads.add(fivehundred);
		numpads.add(done);
		numpads.add(exit);

		rightSide.add(cashEntered, BorderLayout.NORTH);
		rightSide.add(numpads, BorderLayout.CENTER);

		setVendingItemsEnabled(false);

		entry = new JLabel("Burger in your area!!!");
		entry.setFont(new Font("New Courier", Font.CENTER_BASELINE, 25));

		this.add(vendingItems, BorderLayout.CENTER);
		this.add(rightSide, BorderLayout.EAST);
		this.add(entry, BorderLayout.NORTH);
		this.pack();
	}


	public void addViewingSlot(String name, int price, int calories, boolean individuality, int availability)
	{
		JPanel newJPanel = new JPanel();
		newJPanel.setLayout(new GridLayout(5, 1));

		newJPanel.add(new JLabel("Php" + price));
		newJPanel.add(new JLabel(calories + " calories"));
		newJPanel.add(new JLabel(individuality ? "Solo" : "Not Solo"));
		newJPanel.add(new JLabel("x" + availability));
		newJPanel.add(new JButton(name));
		vendingItems.add(newJPanel);
		this.pack();
	}

	public void addDENOMINATIONlistener(ActionListener listener)
	{
		one.addActionListener(listener);
		five.addActionListener(listener);
		ten.addActionListener(listener);
		twenty.addActionListener(listener);
		fifty.addActionListener(listener);
		onehundred.addActionListener(listener);
		fivehundred.addActionListener(listener);
		done.addActionListener(listener);
		exit.addActionListener(listener);
	}

	public void addVendingItemsButtonsListener(ActionListener listener)
	{
		JPanel panel;
		for (Component i: vendingItems.getComponents())
		{
			if (i instanceof JPanel)
			{
				panel = (JPanel) i;
				for (Component j: panel.getComponents())
				{

					if (j instanceof JButton)
					{
						((JButton) j).addActionListener(listener);
					}
				}
			}
		}
	}

	public void updateVendingItemsView(ArrayList <Slot> slots)
	{
		JPanel panel;
		int slotIndex = 0;
		Component[] components;
		for (Component i: vendingItems.getComponents())
		{
			if (i instanceof JPanel)
			{
				panel = (JPanel) i;
				components = panel.getComponents();
				for (int j = 0; j < components.length - 1; j++) // excluding the JButton
				{
					if (components[j] instanceof JLabel)
					{
						if (j == 0)
						{
							((JLabel) components[j]).setText("Php " + slots.get(slotIndex).getPrice());
						}
						else if (j == 1)
						{
							((JLabel) components[j]).setText(slots.get(slotIndex).getCalories() + " calories");
						}
						else if (j == 2)
						{
							((JLabel) components[j]).setText(slots.get(slotIndex).getIndividual() ? "Solo" : "Not Solo");
						}
						else
						{
							((JLabel) components[j]).setText("x" + slots.get(slotIndex).getAvailability());
						}
					}
				}
				slotIndex++;
			}
		}
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

	public void setNumpadsEnabled(boolean enabled)
	{
		Component[] components = numpads.getComponents();
		int i;
		for (i = 0; i < components.length - 1; i++)
		{
			components[i].setEnabled(enabled);
		}
		components[i].setEnabled(!enabled); // for the exit button

	}

	public void setVendingItemsEnabled(boolean enabled)
	{
		JPanel panel;
		for (Component i: vendingItems.getComponents())
		{
			if (i instanceof JPanel)
			{
				panel = (JPanel) i;

				for (Component j: panel.getComponents())
				{
					j.setEnabled(enabled);
				}
			}
		}
	}

	public void setVendingItemsEnabledForRegularVendingMachine(ArrayList<Slot> slots)
	{
		JPanel panel;
		int slotIndex = 0;
		for (Component i: vendingItems.getComponents())
		{
			if (i instanceof JPanel)
			{
				panel = (JPanel) i;

				for (Component j: panel.getComponents())
				{
					if (slots.get(slotIndex).getAvailability() > 0 && slots.get(slotIndex).getIndividual())
					{
						j.setEnabled(true);
					}
					else
					{
						j.setEnabled(false);
					}

				}
				slotIndex++;
			}
		}

	}


	public JButton getOne()
	{
		return one;
	}

	public JButton getFive()
	{
		return five;
	}

	public JButton getTen()
	{
		return ten;
	}

	public JButton getTwenty()
	{
		return twenty;
	}

	public JButton getFifty()
	{
		return fifty;
	}

	public JButton getOnehundred()
	{
		return onehundred;
	}

	public JButton getFivehundred()
	{
		return fivehundred;
	}

	public JButton getDone()
	{
		return done;
	}

	public JButton getExit()
	{
		return exit;
	}


	public JLabel getCashEntered()
	{
		return cashEntered;
	}


}

