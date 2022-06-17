import java.util.Scanner;

/**The purpose of this class is to call the Parent class FoodItem to finish the input of a FoodItem to include its 
 * orchard supplier by calling super()
 * @author Justin Warkus-Fortin (040966794)
 * Assignment 1
 * June 20th 2020
 * @version 1.0
 * @since 1.8
 */
public class Fruit extends FoodItem {
	String orchardName;
	/**
	 * The constructor has no parameters and returns nothing.
	 * This constructor initializes the orchardName to "".
	 */
	public Fruit() {
		this.orchardName = "";
	}
	/**
	 * This toString calls on the super() and adds this toString to it so it can display the orchardName as well
	 */
	public String toString() {
		return super.toString() + " orchard name: " + orchardName;
	}
	/**
	 * This method calls on the super().addItem so that the user will be prompted for all the values from that method and then
	 * will ask the user to enter the orchard supplier as well
	 * @param scan Scanner to allow for user input
	 * @return true as the orchard supplier name can be any input
	 */
	public boolean addItem(Scanner scan) {
		super.addItem(scan);
		System.out.print("Enter the name of the orchard supplier: ");
		scan.nextLine();
		orchardName = scan.nextLine();
		return true;
		
	}
}
