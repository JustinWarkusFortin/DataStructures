import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Justin Warkus-Fortin
 * Student Number:  40966794
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Lab1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Numbers numbers = new Numbers();
		Lab1 lab = new Lab1();
		Scanner scan = new Scanner(System.in);
		
		String array = "";
		
		while(!array.equals("6")) {
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
					
					}catch(NegativeArraySizeException e) {
						System.out.print("Array can't be negative!!\n");
					}catch(InputMismatchException e) {
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
					System.out.print("Average of the numbers is: "+numbers.calcAverage()+"\n");
					System.out.print("Median of the numbers is: "+ numbers.calcMedian()+"\n");
					break;
				case "6":
					System.out.print("Exiting...");
					break;
				default: System.out.print("Invalid option.\n");
			}
			
		}
		
		
		
	}
	public  void displayMainMenu() {
		System.out.print("Please select one of the following:\n"+
						 "1: Initialize a default array\n"+
						 "2: To specify the max size of the array\n"+
						 "3: Add value to the array\n"+
						 "4: Display values in the array\n"+
						 "5: Display the average and the median of the values\n"+ 
						 "6: To Exit\n"+
						"> ");
		
	}

}
