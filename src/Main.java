import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int choice;
		int which;
		boolean created = false;
		boolean specialcreated = false;
		
		Item bun = new Item("Bun", 120, 20, true, 1);
		Item tomato = new Item("Tomato", 25, 15, false, 0);
		Item chickenfillet = new Item("Chicken Fillet", 239, 150, true, 2);
		Item mozarella = new Item("Mozarella", 150, 31, false, 0);
		Item patty = new Item("Patty", 251, 169, true, 2);
		Item lettuce = new Item("Lettuce", 30, 17, false, 0);
		Item onion = new Item("Onion", 30, 17, false, 0);
		Item fishfillet = new Item("Fish fillet", 207, 172, true, 2);

		Vending vendingMachine = new Vending(new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new VendingView("Regular vending machine"));
		SpecialVending specialVendingMachine = new SpecialVending(new SpecialVendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new SpecialVendingView("Special vending machine"));

		MainModel mainModel = new MainModel(vendingMachine, specialVendingMachine);
		MainView mainView = new MainView("Main menu");
		MainController mainController = new MainController(mainModel, mainView);
//		try
//		{
//			while (!exit)
//			{
//				System.out.println("Main Menu: ");
//				System.out.println("0 - Create a vending machine");
//				System.out.println("1 - Test a vending machine");
//				System.out.println("2 - Exit");
//
//				choice = input.nextInt();
//				switch(choice)
//				{
//					case 0:
//						which = chooseVendingMachine(input, vendingMachine, specialVendingMachine);
//						if (which == 0)
//						{
//							created = true;
//							specialcreated = false;
//						}
//						else
//						{
//							specialcreated = true;
//							created = false;
//						}
//						break;
//					case 1:
//						if (created)
//						{
//							testingVendingMachine(input, vendingMachine);
//						}
//						else if (specialcreated)
//						{
//							testingVendingMachine(input, specialVendingMachine);
//						}
//						else
//						{
//							System.out.println("No vending machine has been created");
//						}
//						break;
//					case 2:
//						exit = true;
//						break;
//					default:
//						System.out.println("Try another value!!!");
//				}
//
//			}
//		}
//		catch (InputMismatchException e)
//		{
//			System.out.println("Input error");
//			e.printStackTrace();
//		}
		
		input.close();
	}

	/**
	 * This method asks the user to choose between the special vending machine or just a regular based on how the user wants the machine to operater.
	 *
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @param vendingMachine refers to the regular vending machine class
	 * @param specialVendingMachine refers to the special regular vending machine class
	 * @return an int  for the choice of the user
	 */
	public static int chooseVendingMachine(Scanner input, Vending vendingMachine, SpecialVending specialVendingMachine) {
		int choice = 0;
		System.out.println("[0] - Regular Vending Machine      [1] - Special Vending Machine");

		try {
			choice = input.nextInt();

			switch (choice) {
				case 0: {
					vendingMachine.resetSlots();


					for (int i = 0; i < vendingMachine.getAvailableChanges().length; i++) {
						vendingMachine.setAvailableChange(10, i);

					}
					for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
						vendingMachine.getSlots().get(i).stock(10);

					}
					break;
				}
				case 1: {
					specialVendingMachine.resetSlots();


					for (int i = 0; i < specialVendingMachine.getAvailableChanges().length; i++) {
						specialVendingMachine.setAvailableChange(10, i);

					}
					for (int i = 0; i < specialVendingMachine.getSlots().size(); i++) {
						specialVendingMachine.getSlots().get(i).stock(10);

					}
					break;
				}
				default: {
					System.out.println("Pick between 0 or 1 only");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Input error");
			e.printStackTrace();
		}
		return choice;
	}

	/**
	 * This method refers to the maintenance feature of the vending machine
	 *
	 * @param vendingMachine refers to the any subclass under AbstractVending
	 * @param input refers to the object that will take the input of the user in the terminal
	 */
	public static void vendingMaintenance(AbstractVending vendingMachine, Scanner input)
	{
		boolean exit = false;
		int choice,food=-1, num=0;

		try {
			while (!exit) {
				System.out.println("0 - Restocking");
				System.out.println("1 - Set item price");
				System.out.println("2 - collect money");
				System.out.println("3 - replenish money");
				System.out.println("4 - Print summary of transactions");
				System.out.println("5 - Exit maintenance");
				choice = input.nextInt();

				switch (choice) {
					case 0:
						System.out.printf("%28s", "Select which item to stock\n");
						System.out.println("==============================================");
						for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
							System.out.printf("%d: %-15s: %d items\n", i, vendingMachine.getSlots().get(i).getName(), vendingMachine.getSlots().get(i).getAvailability());
						}
						System.out.println("==============================================");
						do
						{
							food = input.nextInt();
							if (food < 0 || food >= vendingMachine.getSlots().size())
							{
								System.out.println("Input error, please try again");
							}
						}while (food < 0 || food > vendingMachine.getSlots().size());
						System.out.println("==============================================");
						System.out.printf("How much %s/s will you stock?\n", vendingMachine.getSlots().get(food).getName());
						System.out.println("==============================================");
						do
						{
							num = input.nextInt();
							if (num < 0) {
								System.out.println("Input error, please try again");
							}
						}while (num < 0);
						vendingMachine.getSlots().get(food).stock(num);
						System.out.println("==============================================");
						System.out.printf("The %s/s is/are now %d\n", vendingMachine.getSlots().get(food).getName(), vendingMachine.getSlots().get(food).getAvailability());
						System.out.println("==============================================");
						for (int i = 0; i < vendingMachine.getSlots().size(); i++)
						{
							vendingMachine.getSlots().get(i).setSold(0);
							vendingMachine.getSlots().get(i).setSale(0);
						}
						break;
					case 1:
						System.out.printf("%28s", "Select which item to change price\n");
						System.out.println("==============================================");
						for (int i = 0; i < vendingMachine.getSlots().size(); i++)
						{
							System.out.printf("%d: %-15s: %d php\n", i, vendingMachine.getSlots().get(i).getName(), vendingMachine.getSlots().get(i).getPrice());
						}
						System.out.println("==============================================");
						do
						{
							food = input.nextInt();
							if (food < 0 || food >= vendingMachine.getSlots().size())
							{
								System.out.println("Input error, please try again");
							}
						}while (food < 0 || food > vendingMachine.getSlots().size());
						System.out.println("==============================================");
						System.out.printf("How much will the %s/s be?\n", vendingMachine.getSlots().get(food).getName());
						System.out.println("==============================================");
						do
						{
							num = input.nextInt();
							if (num < 0) {
								System.out.println("Input error, please try again");
							}
						}while (num < 0);
						vendingMachine.getSlots().get(food).setPrice(num);
						System.out.println("==============================================");
						System.out.printf("The cost of the %s/s is/are now %d Php\n", vendingMachine.getSlots().get(food).getName(), vendingMachine.getSlots().get(food).getPrice());
						System.out.println("==============================================");
						break;
					case 2:
						long total =0;
						for (int i=0; i<vendingMachine.getSlots().size(); i++)
						{
							total = total + (vendingMachine.getSlots().get(i).getPrice()*vendingMachine.getSlots().get(i).getSold());
							vendingMachine.getSlots().get(i).setSold(0);
							vendingMachine.getSlots().get(i).setSale(0);
						}
						System.out.println("==============================================");
						System.out.printf("%d Php collected\n",total);
						System.out.println("==============================================");
						break;
					case 3:
						int money,qty;
						System.out.println("==============================================");
						for(int i=0;i<vendingMachine.getAvailableChanges().length;i++)
						{
							System.out.printf("[%d]: %d php (%d)\n", i,vendingMachine.getDENOMINATION(i),vendingMachine.getAvailableChange(i));
						}
						System.out.println("==============================================");
						do {

							System.out.println("What do you want to replenish");
							money = input.nextInt();
							if(money < 0 ||money >= vendingMachine.getAvailableChanges().length)
							{
								System.out.println("Wrong input");
							}
						}while(money < 0 ||money >= vendingMachine.getAvailableChanges().length);
						System.out.println("==============================================");
						System.out.printf("What is the quantity you want to add to the %d php\n",vendingMachine.getDENOMINATION(money));
						do
						{
							qty = input.nextInt();
							if(qty<1)
							{
								System.out.println("Wrong input");
							}
						}while(qty<1);
						System.out.println("==============================================");
						vendingMachine.setAvailableChange(qty+vendingMachine.getAvailableChange(money),money);
						System.out.printf("Number of available changes is set to %d\n",vendingMachine.getAvailableChange(money));
						System.out.println("==============================================");
						break;
					case 4:
						vendingMachine.printReport();
						break;
					case 5:
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

	/**
	 * This method executes the vending machines main actions where the user can either be the owner or a buyer.
	 *
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @param vendingMachine refers to the Vending class
	 */
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
					case 1:
						vendingMaintenance(vendingMachine, input);
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

	/**
	 * This method executes the vending machines main actions where the user can either be the owner or a buyer
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @param specialVendingMachine refers to the special Vending class
	 */
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
						specialVendingFeatures(input, specialVendingMachine);
						break;
					case 1:
						vendingMaintenance(specialVendingMachine, input);
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

	/**
	 * This method does the transaction of a vending machine.
	 *
	 * @param slotIndex is the slot number of the item picked
	 * @param amount is the total amount to be paid
	 * @param vendingMachine is any subclass of the AbstractVending
	 */
	public static void vendingSelection(int slotIndex, int amount, AbstractVending vendingMachine)
	{
		int change;

		if (slotIndex < vendingMachine.getSlots().size() && slotIndex >= 0)
		{
			if (!vendingMachine.getSlots().get(slotIndex).getIndividual())
			{
				System.out.println("Sorry, this item is only available as add-ons");
				System.out.println("Your change is " + amount);
			}
			else if (vendingMachine.getSlots().get(slotIndex).getAvailability() > 0)
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
	}

	/**
	 * This method executes the avaiable feature to the regular vending machine.
	 *
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @param vendingMachine refers to the Vending class
	 */
	public static void vendingFeatures(Scanner input, Vending vendingMachine)
	{
		int amount;
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
			vendingSelection(slotIndex, amount, vendingMachine);

			input.nextLine();
			do
			{
				System.out.print("Would like to continue [y/n]? ");
				exitornot = input.nextLine();
			}while(exitornot.compareToIgnoreCase("y") != 0 && exitornot.compareToIgnoreCase("n") != 0);
			
			if (exitornot.compareToIgnoreCase("n") == 0)
			{
				exit = true;
			}
			
		}
		
	}

	/**
	 * This method executes the special vending machine features.
	 *
	 * @param input refers to the object that will take the input of the user in the terminal
	 * @param specialVendingMachine refers to the specialVending class
	 */
	public static void specialVendingFeatures(Scanner input, SpecialVending specialVendingMachine)
	{
		int amount;
		int change;
		int slotIndex = 0;
		int slotIndex2 = 0;
		Item bun;
		Item meat;
		boolean exit = false;
		boolean bunprocess;
		boolean meatprocess;
		boolean process = false;
		boolean done = false;
		String exitornot;
		String payornot;
		while (!exit)
		{
			specialVendingMachine.viewVendingMachine();
			amount = specialVendingMachine.enterCash(input);
			specialVendingMachine.viewVendingMachine();
			System.out.print("Select your item: ");
			slotIndex = input.nextInt();
			if (slotIndex <= specialVendingMachine.getSlots().size() && slotIndex >= 0)
			{
				if (slotIndex == specialVendingMachine.getSlots().size())
				{

					bunprocess = false;
					meatprocess = false;
					process = true;
					done = false;

					do
					{
						System.out.println("Pick your bun: ");
						slotIndex = input.nextInt();
						if (slotIndex >= specialVendingMachine.getSlots().size() || slotIndex < 0)
						{
							process = false;
						}
						else if (specialVendingMachine.getSlots().get(slotIndex).getAvailability() > 0)
						{
							if (specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst().getType() == 1)
							{
								bunprocess = true;
							}
							else
							{
								System.out.println("That ain't a bun");
							}
						}
						else
						{
							System.out.println("Sorry, the item you picked is unavailable as of the moment\nSorry for the inconvenience");
						}



					}while(!bunprocess && process);

					while(!meatprocess && process)
					{
						System.out.println("Pick your meat: ");
						slotIndex2 = input.nextInt();
						if (slotIndex2 >= specialVendingMachine.getSlots().size() || slotIndex2 < 0)
						{
							process = false;
						}
						else if (specialVendingMachine.getSlots().get(slotIndex2).getAvailability() > 0)
						{
							if (specialVendingMachine.getSlots().get(slotIndex2).getItems().getFirst().getType() == 2)
							{
								meatprocess = true;
							}
							else
							{
								System.out.println("That ain't meat");
							}
						}
						else
						{
							System.out.println("Sorry, the item you picked is unavailable as of the moment\nSorry for the inconvenience");
						}

					}

					if (process)
					{
						bun = new Item(specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst());
						meat = new Item(specialVendingMachine.getSlots().get(slotIndex2).getItems().getFirst());

						specialVendingMachine.setUpCustomized(bun, meat);
						specialVendingMachine.getSlots().get(slotIndex).destroyItem();
						specialVendingMachine.getSlots().get(slotIndex2).destroyItem();

						do
						{
							System.out.printf("Pick your other items aside from the buns (To finish picking enter %d): ", specialVendingMachine.getSlots().size());
							slotIndex = input.nextInt();

							if (slotIndex == specialVendingMachine.getSlots().size())
							{
								done = true;
							}
							else if (slotIndex >= specialVendingMachine.getSlots().size() || slotIndex < 0)
							{
								process = false;
							}
							else if (specialVendingMachine.getSlots().get(slotIndex).getAvailability() > 0)
							{
								if (specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst().getType() == 2)
								{
									specialVendingMachine.getBurger().addMeat(specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst());
									specialVendingMachine.getSlots().get(slotIndex).destroyItem();
								}
								else if (specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst().getType() == 0)
								{
									specialVendingMachine.getBurger().addIngredient(specialVendingMachine.getSlots().get(slotIndex).getItems().getFirst());
									specialVendingMachine.getSlots().get(slotIndex).destroyItem();
								}
								else
								{
									System.out.println("Sorry, you cannot add this for this is a bun");
								}
							}
							else
							{
								System.out.println("Sorry, the item you picked is unavailable as of the moment\nSorry for the inconvenience");
							}

						}while(!done && process);

					}

					if (!process && !done)
					{
						System.out.println("Your change is " + amount);
					}
					else
					{
						specialVendingMachine.displayCustomized();

						input.nextLine();
						do
						{

							System.out.print("Would like to continue in paying[y/n]? ");
							payornot = input.nextLine();
						}while(payornot.compareToIgnoreCase("y") != 0 && payornot.compareToIgnoreCase("n") != 0);

						if (payornot.compareToIgnoreCase("y") == 0)
						{
							change = specialVendingMachine.change(amount, specialVendingMachine.getBurger().getPrice());
							if (amount < specialVendingMachine.getBurger().getPrice())
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
								specialVendingMachine.makingBurgerProcess();
								System.out.println("Your change is " + change);
							}
						}

					}

					specialVendingMachine.setBurger(null); // technically delete the object

				}
				else
				{
					vendingSelection(slotIndex, amount, specialVendingMachine);
				}

			}
			else
			{
				System.out.println("Your change is " + amount);
			}

			if (!process && !done)
			{
				input.nextLine();
			}
			do
			{
				System.out.print("Would like to continue [y/n]? ");
				exitornot = input.nextLine();
			}while(exitornot.compareToIgnoreCase("y") != 0 && exitornot.compareToIgnoreCase("n") != 0);

			if (exitornot.compareToIgnoreCase("n") == 0)
			{
				exit = true;
			}

		}

	}

}
