import java.util.Scanner;

/**The purpose of this class is to call the Parent class FoodItem to finish the input of a FoodItem to include its 
 * farm supplier by calling super()
 * @author Justin Warkus-Fortin (040966794)
 * Assignment 1
 * June 20th 2020
 * @version 1.0
 * @since 1.8
 */

public class Vegetable extends FoodItem {
	String farmName;
	/**
	 * The constructor has no parameters and returns nothing.
	 * This constructor initializes the farmName to "".
	 */
	public Vegetable() {
		this.farmName = "";
	}
	/**
	 * This toString calls on the super() and adds this toString to it so it can display the farmName as well
	 */
	public String toString() {
		return super.toString() + " farm name: " + farmName;
	}
	/**
	 * This method calls on the super().addItem so that the user will be prompted for all the values from that method and then
	 * will ask the user to enter the farm name as well
	 * @param scan Scanner to allow for user input
	 * @return true as the orchard supplier name can be any input
	 */
	public boolean addItem(Scanner scan) {
		super.addItem(scan);
		System.out.print("Enter the name of the farm supplier: ");
		scan.nextLine();
		farmName = scan.nextLine();
		return true;
	}
}
