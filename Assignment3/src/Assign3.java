import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The purpose of this class is to create the menu that is displayed to the
 * user, as well as the main method that enacts the display menu and all the
 * cases based on the users choice.
* @author Justin Warkus-Fortin (040966794)
 * Assignment 3
 * August 5th 2020
 * @version 1.0
 * @since 1.8
 */

public class Assign3 {
	/**
	 * Main method contains declaration of the scanner that will be passed on
	 * through the methods to be used for user input. It also creates an object
	 * Inventory inv to be able to access its methods The while loop will exit when
	 * user enters 5. Each case handles the required adding of an item, displaying
	 * inventory, buying and selling items. returns nothing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LocalDate date = LocalDate.now();
		Inventory inv = new Inventory();
		String choice = "";
		while (!choice.equals("9")) {
			displayMenu();
			choice = scan.next();
			switch (choice) {
			case "1":
				inv.addItem(scan);
				break;
			case "2":
				System.out.println("Inventory: \n" + inv.toString());
				break;
			case "3":
				if (!inv.updateQuantity(scan, true)) {
					System.out.print("Code not found in inventory...\nError...could not buy item\n");
					break;
				}
				break;
			case "4":
				if (!inv.updateQuantity(scan, false)) {
					System.out.print("Code not found in inventory...\nError...could not sell item\n");
					break;
				}
				break;
			case "5":
				System.out.print("Please enter code of item to search: ");
				break;
			case "6":
				inv.removeExpired(date);
			case "7":
				if (!inv.printExpired(scan))
					System.out.println("Error, could not print expiry for item");
				break;
			case "8":
				System.out.print(date);
				System.out.print("Please enter today's date (yyyy-mm-dd): ");
				String newDate = scan.next();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				date = LocalDate.parse(newDate, dateFormat);
				System.out.print(date);
				
			case "9":
				System.out.print("Goodbye.");
				break;
			default:
				System.out.print("Error!\n");
				break;
			}

		}

	}

	/**
	 * Private method to display the main menu to the user. Not needed in any other
	 * class so method is private.
	 */
	private static void displayMenu() {
		System.out.print("Please select one of the following:\n" + "1: Add Item to Inventory\n"
				+ "2: Display Current Inventory\n" + "3: Buy Item(s)\n" + "4: Sell Item(s)\n" + "5. Search for item\n"
				+ "6. Remove expired items\n" + "7. Print expiry\n" + "8. Change today's date\n" + "9: To Exit\n" + ">");
	}
}
