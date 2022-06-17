import java.util.Scanner;

/**
 * The purpose of this class is to create the menu that is displayed to the
 * user, as well as the main method that enacts the display menu and all the
 * cases based on the users choice.
 * 
 * @author Justin Warkus-Fortin (040966794) Assignment 1 June 20th 2020
 * @version 1.0
 * @since 1.8
 */

public class Assign2 {
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
		Inventory inv = new Inventory();
		String choice = "";
		while (!choice.equals("8")) {
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
				
			case "4":
				if (!inv.updateQuantity(scan, true)) {
					System.out.print("Code not found in inventory...\nError...could not buy item\n");
					break;
				}
				break;
			case "5":
				if (!inv.updateQuantity(scan, false)) {
					System.out.print("Code not found in inventory...\nError...could not sell item\n");
					break;
				}
				break;
			case "6":
				inv.saveToFile(scan);
				break;
			case "7":
				inv.readFile(scan);
				break;
			case "8":
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
				+ "2: Display Current Inventory\n"+ "3: Search for item in Inventory\n" + "4: Buy Item(s)\n" + "5: Sell Item(s)\n" + "6: Save Inventory to File\n" 
				+ "7: Read Information From File\n" + "8: To Exit\n" + ">");
	}
}
