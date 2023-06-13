import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int choice;
		boolean created = false;
		
		Bun bun = new Bun("Bun", 120, 20, true);
		Other tomato = new Other("Tomato", 25, 15, false);
		Meat chickenfillet = new Meat("Chicken Fillet", 239, 150, true);
		Item mozarella = new Item("Mozarella", 150, 31, false);
		Meat patty = new Meat("Patty", 251, 169, true);
		Other lettuce = new Other("Lettuce", 30, 17, false);
		Other onion = new Other("Onion", 30, 17, false);
		Meat fishfillet = new Meat("Fish fillet", 207, 172, true);
		
		VendingModel vendingModel;
		VendingView vendingView = new VendingView();
		Vending vendingMachine = new Vending(new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), vendingView);

		
		try
		{
			while (!exit)
			{
				System.out.println("Main Menu: ");
				System.out.println("0 - Create a vending machine");
				System.out.println("1 - Test a vending machine");
				System.out.println("2 - Exit");
				
				choice = input.nextInt();
				
				switch(choice)
				{
					case 0: 
						vendingModel = new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet);
						vendingMachine = new Vending(vendingModel, vendingView);
						
						
						for (int i = 0; i < vendingMachine.getAvailableChanges().length; i++)
						{
							vendingMachine.setAvailableChange(10, i);

						}
						for (int i = 0; i < vendingMachine.getSlots().size(); i++)
						{
							vendingMachine.getSlots().get(i).stock(10);;

						}

						created = true;
						
						break;
					case 1:
						if (created)
						{
							testingVendingMachine(input, vendingMachine);
						}
						else
						{
							System.out.println("No vending machine has been created");
						}
						break;
					case 2: 
						exit = true;
						break;
					default:
						System.out.println("Try another value!!!");
				}
				
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Input error");
			e.printStackTrace();
		}
		
		input.close();
	}
	
	public static void testingVendingMachine(Scanner input, Vending vendingMachine)
	{
		boolean exit = false;
		int choice;
		
		try {
			while (!exit)
			{
				System.out.println("0 - Vending features");
				System.out.println("1 - Maintenance features");
				System.out.println("2 - Exit");
				choice = input.nextInt();

				switch(choice)
				{
					case 0:
						vendingFeatures(input, vendingMachine);
						break;
					case 2: 
						exit = true;
						break;
					default:
						System.out.println("Try another value!!!");
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Input error");
			e.printStackTrace();
		}
		
	}
	
	public static void vendingFeatures(Scanner input, Vending vendingMachine)
	{
		int amount;
		int change;
		int slotIndex;
		boolean exit = false;
		String exitornot;
		while (!exit)
		{
			vendingMachine.viewVendingMachine();
			amount = vendingMachine.enterCash(input);
			vendingMachine.viewVendingMachine();
			System.out.print("Select your item: ");
			slotIndex = input.nextInt();
			System.out.println("available change " + vendingMachine.getAvailableChange(0));
			if (slotIndex < vendingMachine.getSlots().size() && slotIndex >= 0)
			{
				if (vendingMachine.getSlots().get(slotIndex).getItems().size() > 0)
				{
					change = vendingMachine.change(amount, vendingMachine.getSlots().get(slotIndex).getPrice());

					if (amount < vendingMachine.getSlots().get(slotIndex).getPrice())
					{
						System.out.println("Not enough cash.");
						System.out.println("Your change is " + amount);
					}
					else if(change == -1)
					{
						System.out.println("Sorry, transaction cannot be made due to insufficient available change");
						System.out.println("Your change is " + amount);
					}
					else
					{
						System.out.println("Your change is " + change);
						System.out.println("available change " + vendingMachine.getAvailableChange(0));

						vendingMachine.getSlots().get(slotIndex).setSold(vendingMachine.getSlots().get(slotIndex).getSold() + 1);
						vendingMachine.getSlots().get(slotIndex).destroyItem();

					}
				}
				else
				{
					System.out.println("Sorry, the item you picked is unavailable as of the moment\nSorry for the inconvenience");
				}
				
			}
			else
			{
				System.out.println("Your change is " + amount);
			}
			
			do
			{
				System.out.print("Would like to continue [y/n]? ");
				input.nextLine();
				exitornot = input.nextLine();
			}while(exitornot.compareToIgnoreCase("y") != 0 && exitornot.compareToIgnoreCase("n") != 0);
			
			if (exitornot.compareToIgnoreCase("n") == 0)
			{
				exit = true;
			}
			
		}
		
	}

}
