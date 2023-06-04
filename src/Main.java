import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int choice;
		boolean created = false;
		
		Item bun = new Item("Bun", 120, 20, 10, true);
		Item tomato = new Item("Tomato", 25, 15, 10 , true);
		Item chickenfillet = new Item("Chicken Fillet", 239, 150, 12 , true);
		Item mozarella = new Item("Mozarella", 150, 31, 10, false);
		Item patty = new Item("Patty", 251, 169, 15, true);
		Item lettuce = new Item("Lettuce", 30, 17, 10, false);
		Item onion = new Item("Onion", 30, 17, 10, false);
		Item fishfillet = new Item("Fish fillet", 207, 172, 10, true);
		
		VendingModel vendingModel = new VendingModel();
		VendingView vendingView = new VendingView();
		Vending vendingMachine = new Vending(vendingModel, vendingView);
		
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
						
						vendingMachine.addSlots(bun);
						vendingMachine.addSlots(tomato);
						vendingMachine.addSlots(chickenfillet);
						vendingMachine.addSlots(mozarella);
						vendingMachine.addSlots(patty);
						vendingMachine.addSlots(lettuce);
						vendingMachine.addSlots(onion);
						vendingMachine.addSlots(fishfillet);
						
						vendingMachine.setOne(1);
						vendingMachine.setFive(6);
						vendingMachine.setTen(3);
						vendingMachine.setTwenty(3);
						vendingMachine.setFifty(10);
						vendingMachine.setOneHundred(5);
						vendingMachine.setFiveHundred(2);

						for (int i = 0; i < vendingMachine.getSlots().size(); i++)
						{
				
							vendingMachine.stock(i, 1);
							System.out.println(vendingMachine.getSlots().get(i).size());

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
			System.out.print("Select your item: ");
			slotIndex = input.nextInt();
			if (slotIndex < vendingMachine.getSlots().size() && slotIndex >= 0)
			{
				if (vendingMachine.getSlots().get(slotIndex).size() > 0)
				{
					change = vendingMachine.change(amount, vendingMachine.getItems().get(slotIndex).getPrice());

					if (amount < vendingMachine.getItems().get(slotIndex).getPrice())
					{
						System.out.println("Not enough cash.");
					}
					else if(change == -1)
					{
						System.out.println("Sorry, transaction cannot be made due to insufficient available change");
					}
					else
					{
						System.out.println("Your change is " + change);
						vendingMachine.getSlots().get(slotIndex).remove(vendingMachine.getSlots().get(slotIndex).size() - 1);

					}
				}
				else
				{
					System.out.println("Sorry, the item you picked is unavailable as of the moment");
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
