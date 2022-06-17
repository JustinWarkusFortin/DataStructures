import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/* The purpose of this assignment is to show the understanding of a binary search algorithm
 * @author Justin Warkus-Fortin (040966794)
 * Lab 5
 * June 20th 2020
 * @version 1.0
 * @since 1.8
 */

public class BinarySearch {
	/**
	 *The main method contains everything from creating the array, displaying the menu, and then all the choices of adding
	 *a value, looking for the index of a value, displaying the array list, as well as exiting.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		while (choice != 4) {
			displayMenu();
			choice = userInput.nextInt();
			switch (choice) {

			case 1:
				System.out.print("Enter Integer to add to array: ");
				String strCode = userInput.next();
				Pattern pattern = Pattern.compile("-?\\d+");
				while (!pattern.matcher(strCode).matches()) {
					System.out.println("Invalid input");
					System.out.print("Enter valid integer to add to array: ");
					strCode = userInput.next();
				}
				int value = Integer.parseInt(strCode);
				intArray.add(value);
				Collections.sort(intArray);
				break;
			case 2:				
				int first = intArray.get(0);
				int last = intArray.size() - 1;
				int requestedInt = 0;
				int mid = (first + last)/2;  
				System.out.print("Search for item: ");
				requestedInt = userInput.nextInt();
				while( first <= last ){  
					      if ( intArray.get(mid) < requestedInt ){  
					        first = mid + 1;     
					      }else if ( intArray.get(mid) == requestedInt){  
					        System.out.println("Element is found at index: " + mid);  
					        break;  
					      }else{  
					         last = mid - 1;  
					      }  
					      mid = (first + last)/2;  
					   }  
					   if ( first > last ){  
					      System.out.println("Index of integer is:  not found!");  
					   }  
				break;
			case 3:
				System.out.print("[ ");
				for(int i=0;i<intArray.size();i++) {
					System.out.print(intArray.get(i)+",");
				}
				System.out.print(" ]\n");
				break;
			case 4:
				System.out.print("Goodbye!");
				break;
			default:
				System.out.print("Invalid input\n");
				break;
			}

	}userInput.close();}
	/**
	 * This method is a simple menu for the user.
	 */
	static void displayMenu() {
		System.out.println("1. Add Item\n2. Search for Item\n3. Display List\n4. Exit");
	}

}