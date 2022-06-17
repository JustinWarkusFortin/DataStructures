import java.util.Scanner;

/**The purpose of this class is to call the Parent class FoodItem to finish the input of a FoodItem to include its 
 * jar size in millilitres(mL) by calling super()
* @author Justin Warkus-Fortin (040966794)
 * Assignment 3
 * August 5th 2020
 * @version 1.0
 * @since 1.8
 */

public class Preserve extends FoodItem {
	int jarSize;
	/**
	 * The constructor has no parameters and returns nothing.
	 * This constructor initializes the jarSize to 0
	 */
	public Preserve() {
		this.jarSize = 0;
	}
	/**
	 * This toString calls on the super() and adds this toString to it so it can display the jarSize as well
	 */
	public String toString() {
		return super.toString() + " size: " + jarSize + "mL";
	}
	/**
	 * This method calls on the super().addItem so that the user will be prompted for all the values from that method and then
	 * will ask the user to enter the jar size as well
	 * @param scan Scanner to allow for user input
	 * @return true as the orchard supplier name can be any input
	 */
	public boolean addItem(Scanner scan) {
		super.addItem(scan);
		System.out.print("Enter the size of the jar in millilitres: ");
		jarSize = scan.nextInt();
		return true;
	}
}
