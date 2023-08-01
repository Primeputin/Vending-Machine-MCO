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

	/**
	 * The main view that opened this view or JFrame.
	 */
	MainView mainSourceFrame;
	/**
	 * A panel that contains the vending items.
	 */
	JPanel vendingItems;
	/**
	 * a panel that contains the necesasry buttons for inputting cash and completing a selection.
	 */
    JPanel numpads;
	/**
	 * Panel that contains the right side of this gui.
	 */
	JPanel rightSide;

	/**
	 * The label that shows the total cash entered.
	 */
	JLabel cashEntered;
	/**
	 *  Greetings for the gui.
	 */
	JLabel entry;
	/**
	 * The button for inputting php 1.
	 */
	JButton one;
	/**
	 * The button for inputting php 5.
	 */
	JButton five;
	/**
	 * The button for inputting php 10.
	 */
	JButton ten;
	/**
	 * The button for inputting php 20.
	 */
	JButton twenty;
	/**
	 * The button for inputting php 50.
	 */
	JButton fifty;
	/**
	 * The button for inputting php 100.
	 */
	JButton onehundred;
	/**
	 * The button for inputting php 500.
	 */
	JButton fivehundred;
	/**
	 * The button for completing the selection.
	 */
	JButton done;
	/**
	 * The button for cancellation a selection.
	 */
	JButton exit;

	/**
	 * The constructor for this class.
	 *
	 * @param name is the name of this JFrame
	 */
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

	/**
	 * This adds a MainView component as one of its fields.
	 *
	 * @param mainSourceFrame is the JFrame that made this JFrame visible
	 */
	public void addMainSourceFrame(MainView mainSourceFrame)
	{
		this.mainSourceFrame = mainSourceFrame;
	}


	/**
	 * This method initializes things for this JFrame.
	 *
	 * @param name is the name of this JFrame
	 */
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
		this.setLocationRelativeTo(null);
	}


	/**
	 * This adds a vending item with its corresponding details and buttons in the GUI.
	 *
	 * @param name is the name of the item
	 * @param price is the price of the item
	 * @param calories is the calories that the food contain
	 * @param individuality is the value whether if the item is add-on or not
	 * @param availability is the number of available stocks of an item
	 */
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

	/**
	 * This adds all the functionality of the numpads for inputting cash and exiting selection.
	 *
	 * @param listener is the one that listens for something to happens. Afterward, it does a certain action for each buttons
	 */
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

	/**
	 * This adds all the functionality of selecting an item button.
	 *
	 * @param listener is the one that listens for something to happens. Afterward, it does a certain action for each buttons
	 */
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

	/**
	 * This update the details of all vending items.
	 *
	 * @param slots refers to the array list of slots and their respective attributes
	 */
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
	 * This enables or disenables the numpads. But, the exit button does the opposite in respect to the argument.
	 *
	 * @param enabled is the value whether to enable or disenable the numpads
	 */
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

	/**
	 * This enables or disenables the vending items buttons.
	 *
	 * @param enabled is the value whether to enable or disenable the numpads
	 */
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

	/**
	 * This is mostly used when the numpad has selected done. The display will enable all the vending items.
	 *
	 * @param slots refers to the array list of slots and their respective attributes
	 */
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

	/**
	 * This method returns the one denonimation button.
	 *
	 * @return the one denomination button
	 */
	public JButton getOne()
	{
		return one;
	}

	/**
	 * This method returns the five denomination button.
	 *
	 * @return the five denomination button
	 */
	public JButton getFive()
	{
		return five;
	}

	/**
	 * This method returns the ten denomination button.
	 *
	 * @return the ten denomination button
	 */
	public JButton getTen()
	{
		return ten;
	}

	/**
	 * This method returns the twenty denomination button.
	 *
	 * @return the twenty denomination button
	 */
	public JButton getTwenty()
	{
		return twenty;
	}

	/**
	 * This method returns the fifty denomination button.
	 *
	 * @return the fifty denomination button
	 */
	public JButton getFifty()
	{
		return fifty;
	}

	/**
	 * This method returns the one hundred denomination button.
	 *
	 * @return the one hundred denomination button
	 */
	public JButton getOnehundred()
	{
		return onehundred;
	}

	/**
	 * This method returns the five hundred denomination button.
	 *
	 * @return the five hundred denomination button
	 */
	public JButton getFivehundred()
	{
		return fivehundred;
	}

	/**
	 * This method returns the done button in the numpad.
	 *
	 * @return the done button
	 */
	public JButton getDone()
	{
		return done;
	}

	/**
	 * This method returns the exit button in the numpad.
	 *
	 * @return the exit button
	 */
	public JButton getExit()
	{
		return exit;
	}

	/**
	 * This method returns the label displaying the cash entered in the vending machine.
	 *
	 * @return the cashEntered label
	 */
	public JLabel getCashEntered()
	{
		return cashEntered;
	}


}

