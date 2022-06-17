import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The purpose of this class is to declare all the methods that will be called
 * by the child classes as well as extra methods that check item codes and
 * update quantity in stock as well.
 * 
 * @author Justin Warkus-Fortin (040966794) Assignment 1 June 20th 2020
 * @version 1.0
 * @since 1.8
 */
public class FoodItem {

	protected int itemCode, itemQuantityInStock;
	protected String itemName;
	protected float itemPrice, itemCost;

	/**
	 * This constructor takes in no parameters and returns nothing. It initializes
	 * all the variables to 0 as well as the itemName to ""
	 */
	public FoodItem() {
		this.itemCode = 0;
		this.itemQuantityInStock = 0;
		this.itemName = "";
		this.itemPrice = 0f;
		this.itemCost = 0f;
	}


	/**
	 * This toString returns the string of the values that will be entered into the
	 * inventory array to be printed out
	 * 
	 * @return String
	 */
	public String toString() {
		return "Item:" + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
				+ itemCost;
	}

	/**
	 * This method creates two patterns to match to when the user inputs the values
	 * for the items they are adding It prompts the user for input and then checks
	 * the condition of a while loop of the pattern desired. If the pattern is not
	 * matched, it prints an error to the user then prompts them again to enter the
	 * same value All inputs are taken in as strings and then parsed into the
	 * correct data type.
	 * 
	 * @param scan Scanner to take in user input
	 * @return boolean will return true no matter what because of Patterns to make
	 *         sure user input is correct and therefore can never fail
	 */
	public boolean addItem(Scanner scan) {
		// Name can be any input
		Pattern pattern2 = Pattern.compile("^\\d+");
		Pattern pattern3 = Pattern.compile("(\\d+)?(\\.\\d+)?");
		System.out.print("Enter the name for the item: ");
		scan.nextLine();
		this.itemName = scan.nextLine();
		// Pattern that doesn't allow any negative numbers
		System.out.print("Enter quantity for the item: ");
		String strQuant = scan.next();
		while (!pattern2.matcher(strQuant).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter quantity for the item: ");
			strQuant = scan.next();
		}
		this.itemQuantityInStock = Integer.parseInt(strQuant);

		System.out.print("Enter the cost of the item: ");
		String strCost = scan.next();
		while (!pattern3.matcher(strCost).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter the cost of the item: ");
			strCost = scan.next();
		}
		this.itemCost = Float.parseFloat(strCost);

		System.out.print("Enter the sales price of the item: ");
		String strPrice = scan.next();
		while (!pattern3.matcher(strPrice).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter the sales price of the item: ");
			strPrice = scan.next();
		}
		this.itemPrice = Float.parseFloat(strPrice);

		return true;
	}

	/**
	 * This method will take in the quantity of items that will be bought or sold
	 * and checks if the itemQuantityInStock will still be above 0 or not When the
	 * method is called and the parameter is entered, the user input is entered as a
	 * negative and therefore only 1 calculation is necessary for both selling and
	 * buying
	 * 
	 * @param amount the amount the itemQuantityInStock will be modified by.
	 * @return returns if the selling or buying was successful or not
	 */
	public boolean updateItem(int amount) {
		if (itemQuantityInStock + amount >= 0) {
			itemQuantityInStock += amount;
			return true;
		}
		System.out.print("Insufficient stock in inventory..\nError...could not sell item.\n");
		return false;
	}

	/**
	 * This method checks if a FoodItem itemCode matches the one entered.
	 * 
	 * @param item the item to check
	 * @return returns true if they match, false otherwise
	 */
	public boolean isEqual(FoodItem item) {
		if (item.itemCode == this.itemCode) {
			return true;
		} else
			return false;
	}

	/**
	 * This method prompts the user to enter an itemCode, the pattern matches it
	 * then parses into an int as needed
	 * 
	 * @param scan Scanner to take user input
	 * @return because of the pattern, the method returns true
	 */
	public boolean inputCode(Scanner scan) {
		// Taking in string input then converting to int if possible.Input must be an
		// integer.
		System.out.print("Enter item code: ");
		String strCode = scan.next();
		Pattern pattern = Pattern.compile("-?\\d+");
		while (!pattern.matcher(strCode).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter item code: ");
			strCode = scan.next();
		}
		this.itemCode = Integer.parseInt(strCode);
		return true;
	}

	public String fileString() {
		return this.itemCode + "\n" + this.itemName + "\n" + this.itemQuantityInStock + "\n" + this.itemCost + "\n"
				+ this.itemPrice + "\n";
	}
	
}
	
