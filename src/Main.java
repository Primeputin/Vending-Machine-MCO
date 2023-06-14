import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int choice;
		int which;
		boolean created = false;
		boolean specialcreated = false;
		
		Bun bun = new Bun("Bun", 120, 20, true);
		Other tomato = new Other("Tomato", 25, 15, false);
		Meat chickenfillet = new Meat("Chicken Fillet", 239, 150, true);
		Item mozarella = new Item("Mozarella", 150, 31, false);
		Meat patty = new Meat("Patty", 251, 169, true);
		Other lettuce = new Other("Lettuce", 30, 17, false);
		Other onion = new Other("Onion", 30, 17, false);
		Meat fishfillet = new Meat("Fish fillet", 207, 172, true);

		Vending vendingMachine = new Vending(new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new VendingView());
		SpecialVending specialVendingMachine = new SpecialVending(new SpecialVendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new SpecialVendingView());

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
						which = chooseVendingMachine(input, vendingMachine, specialVendingMachine);
						if (which == 0)
						{
							created = true;
							specialcreated = false;
						}
						else
						{
							specialcreated = true;
							created = false;
						}
						break;
					case 1:
						if (created)
						{
							testingVendingMachine(input, vendingMachine);
						}
						else if (specialcreated)
						{
							testingVendingMachine(input, specialVendingMachine);
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

	public static int chooseVendingMachine(Scanner input, Vending vendingMachine, SpecialVending specialVendingMachine)
	{
		int choice = 0;
		System.out.println("[0] - Regular Vending Machine      [1] - Special Vending Machine");

		try
		{
			choice = input.nextInt();

			switch(choice)
			{
				case 0:
				{
					vendingMachine.resetSlots();


					for (int i = 0; i < vendingMachine.getAvailableChanges().length; i++)
					{
						vendingMachine.setAvailableChange(10, i);

					}
					for (int i = 0; i < vendingMachine.getSlots().size(); i++)
					{
						vendingMachine.getSlots().get(i).stock(10);

					}
					break;
				}
				case 1:
				{
					specialVendingMachine.resetSlots();


					for (int i = 0; i < specialVendingMachine.getAvailableChanges().length; i++)
					{
						specialVendingMachine.setAvailableChange(10, i);

					}
					for (int i = 0; i < specialVendingMachine.getSlots().size(); i++)
					{
						specialVendingMachine.getSlots().get(i).stock(10);

					}
					break;
				}
				default:
				{
					System.out.println("Pick between 0 or 1 only");
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Input error");
			e.printStackTrace();
		}
		return choice;
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

	public static void testingVendingMachine(Scanner input, SpecialVending specialVendingMachine)
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
						vendingFeatures(input, specialVendingMachine);
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

	public static void vendingFeatures(Scanner input, SpecialVending specialVendingMachine)
	{
		int amount;
		int change;
		int slotIndex;
		boolean exit = false;
		String exitornot;
		while (!exit)
		{
			specialVendingMachine.viewVendingMachine();
			amount = specialVendingMachine.enterCash(input);
			specialVendingMachine.viewVendingMachine();
			System.out.print("Select your item: ");
			slotIndex = input.nextInt();
			if (slotIndex < specialVendingMachine.getSlots().size() && slotIndex >= 0)
			{
				if (specialVendingMachine.getSlots().get(slotIndex).getItems().size() > 0)
				{
					change = specialVendingMachine.change(amount, specialVendingMachine.getSlots().get(slotIndex).getPrice());

					if (amount < specialVendingMachine.getSlots().get(slotIndex).getPrice())
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
						specialVendingMachine.getSlots().get(slotIndex).destroyItem();
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
