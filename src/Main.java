import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Item bun = new Item("Bun", 120, 20, true, 1);
		Item tomato = new Item("Tomato", 25, 15, false, 0);
		Item chickenfillet = new Item("Chicken Fillet", 239, 150, true, 2);
		Item mozarella = new Item("Mozarella", 150, 31, false, 0);
		Item patty = new Item("Patty", 251, 169, true, 2);
		Item lettuce = new Item("Lettuce", 30, 17, false, 0);
		Item onion = new Item("Onion", 30, 17, false, 0);
		Item fishfillet = new Item("Fish fillet", 207, 172, true, 2);

		MainView mainView;

		Vending vendingMachine = new Vending(new VendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new VendingView("Regular vending machine"));
		SpecialVending specialVendingMachine = new SpecialVending(new SpecialVendingModel(bun, tomato, chickenfillet, mozarella, patty, lettuce, onion, fishfillet), new SpecialVendingView("Special vending machine"));

		MainModel mainModel = new MainModel(vendingMachine, specialVendingMachine);
		mainView = new MainView("Main menu");
		MainController mainController = new MainController(mainModel, mainView);
	}



}
