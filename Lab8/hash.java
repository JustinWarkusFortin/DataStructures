import java.util.ArrayList;
import java.util.Scanner;
/* The purpose of this assignment is to enter a string and use a has algorithm to determine where to place it in the array list
 * 
 * @author Justin Warkus-Fortin (040966794)
 * Lab 8
 * July 31st 2020
 * @version 1.0
 * @since 1.8
 */
public class hash {
	public static void main(String[] args) {
		
		//Creates and initializes the dataItems ArrayList
		ArrayList<String> dataItems = new ArrayList<String>(100);
		for (int i = 1; i <= 100; i++) {
			dataItems.add("");
		}
		Scanner scan = new Scanner(System.in);
		String choice = "";
		/**
		 * While loop that handles the 3 possible cases of user input, including the add string,
		 * searching for a string as well as exiting the program
		 */
		while (choice != "3") {
			System.out.print("\n1.Add\n2.Search\n3.Exit\n>");
			choice = scan.next();
			switch (choice) {
			case "1":
				int a, b = 0;
				System.out.print("Enter String: ");
				String temp = scan.next();
				//Gets first character of string for hash algorithm
				a = (int) (temp.charAt(0));
				if (temp.length() > 1) {
					//Gets second character of string for hash algorithm if there is one
					b = (int) (temp.charAt(1));
				}
				//Modulos 100 to make sure the result is 0-99
				int index = (a + b) % 100;
				//Adds to the index location if empty
				if (dataItems.get(index) == "") {
					dataItems.add(index, temp);
					System.out.print("String entered at index: " + index);
					//Otherwise moves to the next index until it reaches 99 and fails.
				} else {
					for (int i = index+1; i <= 99; i++) {
						if (dataItems.get(i) == "") {
							dataItems.add(1, temp);
							System.out.print("String entered at index: " + i);
							break;
						} else {
							System.out.print("Could not add string\n");
						}
					}

				}
				break;
			case "2":
				//Very similar to case 1 
				int c, d = 0;
				System.out.print("Enter String: ");
				String temp2 = scan.next();
				c = (int) (temp2.charAt(0));
				if (temp2.length() > 1) {
					d = (int) (temp2.charAt(1));
				}

				int index2 = (c + d) % 100;
				//Checks if the string is in the ArrayList and if it is will print its index, otherwise will fail and print a message.
				if(dataItems.contains(temp2)) {
					System.out.print(temp2+" is found at index: "+index2);
				}else
					System.out.print("Could not find string\n");
				break;
			case "3":
				//Quick message to the user before exiting.
				System.out.print("Goodbye!");
				choice="3";
				break;
			default:
				//Handles any input other than the 3 for the menu
				System.out.print("Invalid input!\n");
			}

		}
		scan.close();

	}

}
