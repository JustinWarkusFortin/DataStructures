import java.util.Scanner;

/**
 * The purpose of this class is to prompt the user for a String and the program will tell the user if it is a palindrome or not.
 * It will exit only if the user types exit.
 * @author Justin Warkus-Fortin (040966794)
 * Lab 4
 * June 21st 2020
 * @version 1.0
 * @since 1.8
 */

public class Lab4 {
	/**
	 * The main method prompts the user for the word they wish to check.
	 * if statements check if the user entered exit to quit the program or 
	 * if they entered a word and whether the method will be true/false.
	 * @param args
	 */
	public static void main(String[] args) {
		String pal = "";
		Scanner scan = new Scanner(System.in);
		while (pal!="exit") {
			System.out.print("Please enter a palindrome or exit to terminate the program: ");
			pal = scan.nextLine();
			if(pal.contentEquals("exit")) {
				System.out.print("Goodbye!");
				break;
			}
			if (isPalindrome(pal) == true) {
				System.out.print(pal + " IS a palindrome\n");
			} else if (isPalindrome(pal) == false) {
				System.out.print(pal + " IS NOT a palindrome\n");
			}
		}

		scan.close();
	}
	/**
	 * This method takes in the string to check each letter from first and last all the way to the 
	 * middle to check if they are the same and if the word is in fast a palindrome.
	 * @param pal String that will be passed to the method to be checked every time it is called.
	 * @return return whether the String is a palindrome (true) or not (false).
	 */
	private static boolean isPalindrome(String pal) {
		if (pal.length() == 0 || pal.length() == 1) {
			return true;
		}
		if (pal.charAt(0) == pal.charAt(pal.length() - 1)) {
			return isPalindrome(pal.substring(1, pal.length() - 1));
		}
		return false;
	}
}
