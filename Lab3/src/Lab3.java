import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Justin Warkus-Fortin Student Number: 40966794 Course: CST8130 -
 * Data Structures : CET-CS-Level 3
 * 
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Lab3 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Numbers numbers = new Numbers();
		Lab3 lab = new Lab3();
		Scanner scan = new Scanner(System.in);

		String array = "";

		while (!array.equals("10")) {
			lab.displayMainMenu();
			array = scan.next();
			switch (array) {
			case "1":
				numbers = new Numbers();
				break;
			case "2":
				System.out.print("Please enter the size of the array: ");
				try {
					numbers = new Numbers(scan.nextInt());
					scan.nextLine();

				} catch (NegativeArraySizeException e) {
					System.out.print("Array can't be negative!!\n");
				} catch (InputMismatchException e) {
					System.out.print("Invalid choice!");
				}

				break;
			case "3":
				System.out.print("Enter a float value: ");
				numbers.addValue(scan);
				break;
			case "4":
				System.out.print("Numbers are:\n" + numbers);
				break;
			case "5":
				System.out.print("Average of the numbers is: " + numbers.calcAverage() + "\n");
				System.out.print("Median of the numbers is: ");
				System.out.printf("%.2f %n", numbers.calcMedian());
				break;
			case "6":
				Scanner s = new Scanner(System.in);
				System.out.print("How many numbers would you like to add?: ");
				int choice = s.nextInt();
				if (choice > numbers.getNumbers().length) {
					System.out.print("No room in array to add all values\n");
					break;
				} else
					for (int i = 0; i < choice; i++) {
						System.out.print("Enter a value: ");
						numbers.addValue(scan);
					}
				break;
			case "7":
				System.out.print("Enter file name: ");
				String fileName = scan.next();
				String filePath = "C:\\temp\\" + fileName;
				File pathCheck = new File(filePath);
				if (pathCheck.exists()) {
					numbers.fileNumbers(filePath);
					System.out.print("\n");
					break;
				} else {
					System.out.print("That file does not exist.\n");
					break;
				}
			case "8":
				System.out.print("Enter file name: ");
				String saveToFileName = scan.next();
				String finalPath = "C:\\temp\\" + saveToFileName;
				numbers.writeFile(finalPath);
				break;
			case "9":
				System.out.print("Insertion sort output: "+numbers.insertionSort());
				System.out.print("\nSelection sort output: "+numbers.selectionSort());
				System.out.print("\nBubble sort output: " + numbers.bubbleSort()+"\n");
				break;
			case "10":
				System.out.print("Exiting...");
				break;
			default:
				System.out.print("Invalid option.\n");
			}

		}

	}

	public void displayMainMenu() {
		System.out.print("Please select one of the following:\n" + "1: Initialize a default array\n"
				+ "2: To specify the max size of the array\n" + "3: Add value to the array\n"
				+ "4: Display values in the array\n" + "5: Display the average and the median of the values\n"
				+ "6: Enter multiple values\n" + "7: Read values from file\n" + "8: Save values to file\n"
				+ "9: Sort the array\n" + "10: To Exit\n" + "> ");

	}

}
