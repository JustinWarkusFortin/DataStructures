import java.util.LinkedList;
import java.util.Scanner;

/* The purpose of this assignment is to show the understanding of Linked Lists by checking mathematical expressions to 
 * see if they're balanced or not
 * @author Justin Warkus-Fortin (040966794)
 * Lab 5
 * July 13th 2020
 * @version 1.0
 * @since 1.8
 */
public class LList {
	/**
	 * The main method prompts the user for the expression they wish to check.
	 * if statements check if the user entered exit to quit the program or 
	 * if they entered an expression and whether it will be balanced or not
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		//Simple loop that exits after the user enters exit
		while (!input.equals("exit")) {
			System.out.print("Enter an expression (or exit to terminate): ");
			input = scan.nextLine();
			//Displays quick message before terminating the program
			if (input.equals("exit")) {
				System.out.print("Terminating...");
				break;
			
			}
			//Displays the message to the user the results of the method and theor expression.
			else {
				System.out.println("The expression is " + checkBalanced(input));
			}
		}
		scan.close();
	}
	/**
	 * This method takes in the mathematical expression the user wishes to check and uses a loop to check all the
	 * elements of the List for the specific characters to check ( "()" "{}" "[]" )  and if they are balanced.
	 * @param checkExpression Expression that the method will check
	 * @return Returns whether the expression is balanced or not.
	 */
	static String checkBalanced(String checkExpression) {
		if (checkExpression.isEmpty())
			return "not balanced";
		// Creating a linked list of characters
		LinkedList<Character> list = new LinkedList<Character>();
		// Loops through every character of the expression
		for (int i = 0; i < checkExpression.length(); i++) {
			// makes the current character equal to the character at i
			char current = checkExpression.charAt(i);
			// If any of the 3 characters are encountered, they are added to the head of a
			// linked list.
			if (current == '(' || current == '[' || current == '{') {
				list.push(current);
			}
			if (current == ')' || current == ']' || current == '}') {
				// empty list, mismatch
				if (list.isEmpty()) {
					return "not balanced";
				}
				// Uses list.peek() to copy the first character of a linked list to the variable
				// first.
				char first = list.peek();
				// Checks if there is a match in a linked list then uses the pop() method to
				// removed it from the list.
				if (current == ')' && first == '(' || current == ']' && first == '['
						|| current == '}' && first == '{') {
					list.pop();
				}
			}
		}
		//if all the elements were removed, the method returns balanced, otherwise, it is not balanced
		if (list.isEmpty()) {
			return "balanced";
		} else {
			return "not balanced";
		}
	}

}