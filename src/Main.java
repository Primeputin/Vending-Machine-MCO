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

		VendingModel vendingModel = new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet);
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

						vendingMachine.resetSlots();
						
						
						for (int i = 0; i < vendingMachine.getAvailableChanges().length; i++)
						{
							vendingMachine.setAvailableChange(10, i);

						}
						for (int i = 0; i < vendingMachine.getSlots().size(); i++)
						{
							vendingMachine.getSlots().get(i).stock(10);

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
	public static void vendingMaintenance(Vending vendingMachine, Scanner input)
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
						}
						System.out.printf("%d Php collected\n",total);
						break;
					case 3:
						int money,qty;
						for(int i=0;i<vendingMachine.getAvailableChanges().length;i++)
						{
							System.out.printf("[%d]: %d php (%d)\n", i,vendingMachine.getDENOMINATION(i),vendingMachine.getAvailableChange(i));
						}
						do {

							System.out.println("What do you want to replenish");
							money = input.nextInt();
							if(money < 0 ||money >= vendingMachine.getAvailableChanges().length)
							{
								System.out.println("Wrong input");
							}
						}while(money < 0 ||money >= vendingMachine.getAvailableChanges().length);
						System.out.printf("What is the quantity you want to add to the %d php\n",vendingMachine.getDENOMINATION(money));
						do
						{
							qty = input.nextInt();
							if(qty<1)
							{
								System.out.println("Wrong input");
							}
						}while(qty<1);
						vendingMachine.setAvailableChange(qty+vendingMachine.getAvailableChange(money),money);
						System.out.printf("Number of available changes is set to %d\n",vendingMachine.getAvailableChange(money));
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

}
