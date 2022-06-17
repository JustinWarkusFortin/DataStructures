import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to use the inventory array of FoodItems to
 * populate the inventory, buy, sell, and check item codes if it exists to
 * either allow or disallow the user to enter that code
 * 
* @author Justin Warkus-Fortin (040966794)
 * Assignment 3
 * August 5th 2020
 * @version 1.0
 * @since 1.8
 */

public class Inventory {

	private ArrayList<InventoryItem> inventory;// declaring array of InventoryItems to be initialized in constructor
	private int numItems;// number of FoodItems in the array

	/**
	 * The constructor has no parameters and returns nothing. It initializes the
	 * size of inventory to 20 InventoryItems; As well as numItems at 0 as there is
	 * nothing in inventory yet.
	 */
	public Inventory() {
		inventory = new ArrayList<>();
		numItems = 0;
	}

	/**
	 * This method has no parameters and returns a String is the toString that was
	 * will print out every item in the inventory line by line.
	 * 
	 * @return String
	 */
	public String toString() {
		String words = "";
		if (numItems == 0) {
			return "";
		} else {
			for (int i = 0; i < numItems; i++) {
				words += inventory.get(i) + "\n";
			}
			return words;
		}
	}

	/**
	 * This method takes in the item code of the item you would like to add and
	 * checks if its already in inventory. It's used in the addItem to check before
	 * adding the item to make sure there isn't a duplicate code
	 * 
	 * @param item
	 * @return position
	 */
	private int alreadyExists(FoodItem item) {
		int position = -1;
		for (int i = 0; i < numItems; i++) {
			if (item.isEqual(inventory.get(i))) {
				position = i;// to be used for updating quantity
			}
		}
		return position;// if it fails it returns -1
	}

	/**
	 * This method will prompt you to enter the values for the FoodItem that the
	 * user chooses. It makes use of the toUpperCase() to simplify case options to
	 * only be capital letters it then will prompt the user for the itemCode they
	 * wish to act on, and checks whether it exists and fails or it does not exist
	 * and prompts the user for the rest of the values.
	 * 
	 * @param scan Scanner to prompt user for input.
	 * @return true if adding was successful,false if the code exists.
	 */
	public boolean addItem(Scanner scan) {
		System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
		String choice = scan.next();
		choice = choice.toUpperCase();// Makes input upper case
		switch (choice) {
		case "F":// Easier to compare cases and validate input
			FoodItem fruit = new Fruit();
			fruit.inputCode(scan);
			if (alreadyExists(fruit) != -1) {
				System.out.println("Item already exists");
				return false;
			}
			fruit.addItem(scan);
			InventoryItem invFruit = new InventoryItem(fruit);
			invFruit.addItem(scan);
			inventory.add(binarySearch(invFruit), invFruit);
			numItems++;
			return true;
		case "V":
			FoodItem veg = new Vegetable();
			veg.inputCode(scan);
			if (alreadyExists(veg) != -1) {
				System.out.print("Item already exists");
				return false;
			}
			veg.addItem(scan);
			InventoryItem invVeg = new InventoryItem(veg);
			invVeg.addItem(scan);
			inventory.add(binarySearch(invVeg), invVeg);
			numItems++;
			return true;
		case "P":
			FoodItem preserve = new Preserve();
			preserve.inputCode(scan);
			if (alreadyExists(preserve) != -1) {
				System.out.print("Item already exists");
				return false;
			}
			preserve.addItem(scan);
			InventoryItem invPres = new InventoryItem(preserve);
			invPres.addItem(scan);
			inventory.add(binarySearch(invPres), invPres);
			numItems++;
			return true;
		default:
			// if user input is anything other than f, v, or p, Invalid entry will be
			// printed and the user will be prompted again to enter f, v, p
			System.out.println("Invalid entry");
			addItem(scan);
		}
		return false;
	}

	/**
	 * This method prompts the user to enter the item code of the item the user
	 * would like to purchase or sell, depending on the condition of the item code
	 * matching one in inventory. then it tries to validate the amount entered
	 * before finally updating the item
	 * 
	 * @param scan      Scanner to take user input
	 * @param buyOrSell boolean that makes true=buy and false=sell
	 * @return return used to determine if buying or selling was successful
	 */
	public boolean updateQuantity(Scanner scan, boolean buyOrSell) {
		int amount = 0;
		String amtStr = "";
		if (numItems == 0)
			return false;
		System.out.print("Enter a valid item code: ");
		int itemCode = scan.nextInt();
		for (int i = 0; i < numItems; i++) {
			if (inventory.get(i).getItemCode() == itemCode) {
				// if buyOrSell is true it will prompt the user to enter an amount to buy
				if (buyOrSell) {
					System.out.print("Enter amount to buy: ");
					try {
						return inventory.get(i).updateQuantity(scan, amount = scan.nextInt());
					} catch (InputMismatchException e) {
						System.out.print("Invalid quantity\nError\n");
					}
				} else {// if buyOrSell is false the user will be prompted with an amount to sell
					System.out.print("Enter amount to sell: ");
					if (amount >= 0) {
						amtStr = scan.next();
						try {
							return inventory.get(i).updateQuantity(scan, amount -= Integer.parseInt(amtStr));
						} catch (NumberFormatException e) {
							System.out.print("Invalid quantity...\nError...could not sell item\n");
							continue;
						}
					}

				}
			}
		}
		return false;
	}

	public void removeExpired(LocalDate date) {
		for (int i = 0; i < numItems; i++) {
			inventory.get(i).removeExpiredItems(date);
		}
	}

	private int binarySearch(InventoryItem item) {
		int lowIndex = 0;
		int highIndex = inventory.size() - 1;
		int midIndex = highIndex / 2;

		while (lowIndex <= highIndex) {
			if (item.compareTo(inventory.get(midIndex)) < 0) {
				highIndex = midIndex - 1;
			} else if (item.compareTo(inventory.get(midIndex)) > 0) {
				lowIndex = midIndex + 1;
			} else {
				return midIndex;
			}
			midIndex = (lowIndex + highIndex) / 2;
		}
		return lowIndex;
	}

	public boolean printExpired(Scanner scan) {
		System.out.print("Enter item code: ");
		int itemCode = 0;
		try {
		String strCode = scan.next();
		itemCode = Integer.parseInt(strCode);
		}catch(NumberFormatException e) {
			return false;
		}
		for(int i = 0; i < numItems; i++) {
			if(this.inventory.get(i).getItemCode() == itemCode) {
				inventory.get(i).printExpiry();
				return true;
			}
		}
		return false;
	}
}
