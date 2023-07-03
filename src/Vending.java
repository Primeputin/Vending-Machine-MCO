import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This interacts with the vending view class and gives the values for it to print.
 * It also performs various methods that refer to the action of the vending machine.
 * It inherits the attributes and methods of the AbstractVending class.
 * It contains the variable created as an attribute
 * which represents the boolean if whether the machine is created.
 *
 * @author Vladimir Tang
 *
 */
public class Vending extends AbstractVending{
	
	private VendingModel vendingModel;
	private VendingView vendingView;
	private boolean created = false;

	/**
	 * This constructor method creates a vending model and a vending view class.
	 *
	 * @param vendingModel refers to the VendingModel object
	 * @param vendingView refers to the VendingView object
	 */
	public Vending(VendingModel vendingModel, VendingView vendingView)
	{
		this.vendingModel = vendingModel;
		this.vendingView = vendingView;

		addDENOMINATIONlistener();

	}

	/**
	 * Creates a new slot where a new item will be placed.
	 *
	 * @param item refers to the item class in which it will be placed in a new slot
	 */
	@Override
	public void addSlots(Item item)
	{
		vendingModel.addSlots(item);
	}

	/**
	 * Clear all items in every slot in the vending machine set sold and availability back to zero.
	 */
	@Override
	public void resetSlots()
	{
		vendingModel.resetSlots();
	}

	/**
	 *This method calls the method in slots to initiate the vending machine to accept cash.
	 *
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @return the amount for the total cash inserted
	 */
	@Override
	public int enterCash(Scanner input)
	{
		return vendingModel.enterCash(input);
	}

	/**
	 * This method calls the method in the vendingModel class to return the change of a user.
	 *
	 * @param amount the amount of cash placed in the vending machine
	 * @param cost the price of the item bought
	 * @return the amount of change to be given to the user
	 */
	@Override
	public int change(int amount, int cost)
	{
		return vendingModel.change(amount, cost);
	}

	/**
	 * This method sets the array of integer for the available changes.
	 *
	 * @param availableChanges is the array of available changes respective to the vending machines current number of bills
	 */
	@Override
	public void setAvailableChanges(int[] availableChanges)
	{
		vendingModel.setAvailableChanges(availableChanges);
	}

	/**
	 * This method sets the available change of a specific bill or coin.
	 *
	 * @param quantity the number of bills or coins to be placed
	 * @param index to which bill of coin will be added to
	 */
	@Override
	public void setAvailableChange(int quantity, int index)
	{
		vendingModel.setAvailableChange(quantity, index);
	}

	public void setVendingItemsEnabled(boolean enabled)
	{
		vendingView.setVendingItemsEnabled(enabled);
	}

	/**
	 * This method returns the array for the available change.
	 *
	 * @return the array of ints for the number of available change with respect to their value
	 */
	@Override
	public int[] getAvailableChanges()
	{
		return vendingModel.getAvailableChanges();
	}
	/**
	 * This method returns the available change.
	 *
	 * @param index the index at which bill or coin the vending machine is referring to
	 * @return the number of available change based on the index
	 */
	@Override
	public int getAvailableChange(int index)
	{
		return vendingModel.getAvailableChange(index);
	}

	/**
	 * This method returns the slots of the vending machine.
	 *
	 * @return the array list of slots
	 */
	@Override
	public ArrayList<Slot> getSlots()
	{
		return vendingModel.getSlots();
	}

	/**
	 * This method gets which bill is referred to.
	 *
	 * @param index the index used to refer to the denomination
	 * @return the denomination at which the index is referring to
	 */
	@Override
	public int getDENOMINATION( int index)
	{
		return this.vendingModel.getDENOMINATION(index);
	}

	/**
	 * This method refers to the view vending class which is responsible for the printing of various texts for the vending machine when buying or testing the vending machines features.
	 */
	@Override
	public void viewVendingMachine()
	{
		vendingView.viewVendingMachine(vendingModel.getSlots());
	}

	/**
	 *This method prints the report to on the sales and stocks depending on the last restocking.
	 */
	@Override
	public void printReport(){vendingView.printReport(vendingModel.getSlots());}

	@Override
	public void setDisplay(boolean show)
	{
		vendingView.setVisible(show);
	}

	@Override
	public void addViewingSlot()
	{
		for (Slot i: vendingModel.getSlots())
		{
			vendingView.addViewingSlot(i.getName(), i.getPrice(), i.getCalories(), i.getIndividual(), i.getAvailability());

		}
	}

	@Override
	public void addMainSourceFrame(MainView mainSourceFrame)
	{
		vendingView.addMainSourceFrame(mainSourceFrame);
	}

	@Override
	public void addDENOMINATIONlistener()
	{
		vendingView.addDENOMINATIONlistener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == vendingView.getOne())
				{
					vendingModel.increaseCashEntered(1);
				}
				else if (e.getSource() == vendingView.getFive())
				{
					vendingModel.increaseCashEntered(5);
				}
				else if (e.getSource() == vendingView.getTen())
				{
					vendingModel.increaseCashEntered(10);
				}
				else if (e.getSource() == vendingView.getTwenty())
				{
					vendingModel.increaseCashEntered(20);
				}
				else if (e.getSource() == vendingView.getFifty())
				{
					vendingModel.increaseCashEntered(50);
				}
				else if (e.getSource() == vendingView.getOnehundred())
				{
					vendingModel.increaseCashEntered(100);
				}
				else if (e.getSource() == vendingView.getFivehundred())
				{
					vendingModel.increaseCashEntered(500);
				}
				else if(e.getSource() == vendingView.getDone())
				{
					vendingView.setVendingItemsEnabledForRegularVendingMachine(vendingModel.getSlots());
					vendingView.setNumpadsEnabled(false);
				}
				else if (e.getSource() == vendingView.getExit())
				{
					JOptionPane.showMessageDialog(null, "Your change is Php " + vendingModel.getCashEntered());
					vendingModel.resetCashEntered();
					vendingView.setNumpadsEnabled(true);
					vendingView.setVendingItemsEnabled(false);
				}
				vendingView.getCashEntered().setText("Total cash entered: Php " + vendingModel.getCashEntered());

			}
		});
	}

	public void addVendingItemsButtonsListener()
	{
		vendingView.addVendingItemsButtonsListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Slot i: vendingModel.getSlots())
				{
					if (e.getActionCommand().equals(i.getName()))
					{
						vendingTransaction(i);
					}
				}
				vendingView.setNumpadsEnabled(true);
				vendingView.setVendingItemsEnabled(false);
				updateVendingItemsView();
			}
		});
	}

	public void vendingTransaction(Slot slot)
	{
		int change;

		change = vendingModel.change(slot.getPrice());

		if (vendingModel.getCashEntered() < slot.getPrice())
		{
			JOptionPane.showMessageDialog(null, "<html>Not enough cash<br>Your change is Php" + vendingModel.getCashEntered() + "</html>");
		}
		else if(change == -1)
		{
			JOptionPane.showMessageDialog(null, "<html>Sorry, transaction cannot be made due to insufficient available change<br>Your change is Php" + vendingModel.getCashEntered() + "</html>");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your change is Php " + change);
			slot.destroyItem();
		}

		vendingModel.resetCashEntered();

	}

	@Override
	public void updateVendingItemsView()
	{
		vendingView.updateVendingItemsView(vendingModel.getSlots());
	}


	@Override
	public void defaultSettingsView()
	{
		vendingView.setNumpadsEnabled(true);
		vendingView.setVendingItemsEnabled(false);
		vendingModel.resetCashEntered();
		vendingView.getCashEntered().setText("Total cash entered: Php " + vendingModel.getCashEntered());

	}

}
