import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Justin-Thomas Warkus-Fortin Student Number: 040966794 Course:
 * CST8130 - Data Structures : CET-CS-Level 3
 * 
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {

	private Float[] numbers;
	int numItems = 0;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		setNumbers(new Float[10]);
		numItems = 0;
	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		setNumbers(new Float[size]);
		numItems = 0;
	}

	/**
	 * Adds a value in the array
	 * 
	 * @param keyboard - Scanner object to use for input
	 */

	public void addValue(Scanner keyboard) {
		try {
			numbers[numItems] = keyboard.nextFloat();
			numItems++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Array Full!\n");
		} catch (InputMismatchException e) {
			System.out.print("Invalid symbol!\n");
		}
	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * 
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float average = 0;
		if (numItems != 0) {
			for (int i = 0; i < numItems; i++) {
				average += getNumbers()[i];
			}
			average = average / numItems;
			return (float) average;
		}
		return 0.0f;
	}

	//Print all the numbers as strings each on a new line
	public String toString() {
		String words = "";
		for (int i = 0; i < numItems; i++) {
			words += numbers[i] + "\n";

		}
		return words;
	}
	//Created method to calculate the median of the array
	public double calcMedian() {
		double median = 0;
		//Create new  array to copy from Float[] to float[]
		float[] arrayToSort = new float[numItems];
		for (int i = 0; i < numItems; i++) {
			arrayToSort[i] += (float) numbers[i];
		}
		//Sorting the array by comparing and then swapping numbers should they be bigger or smaller depending on the case
		for (int i = 0; i < arrayToSort.length; i++) {
			for (int j = i + 1; j < arrayToSort.length; j++) {
				if (arrayToSort[i] > arrayToSort[j]) {
					double temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = (float) temp;
				}
			}
		}
		//Returns 0 when array empty
		if(numItems == 0) {
			return 0.0;
		}
		//When there is an even number of items in the array
		else if (numItems % 2 > 0) {
			median = arrayToSort[arrayToSort.length / 2];
			return median;
		}//Handles when there are an even number of items in the array 
		else if (numItems % 2 == 0) {
			median = arrayToSort[arrayToSort.length / 2] + arrayToSort[(arrayToSort.length / 2) - 1];
			median /= 2;
			return median;
		} 
		return 0.0;
	}
	//Basic getter and setter for numbers array
	public Float[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Float[] numbers) {
		this.numbers = numbers;
	}
	//Method that reads the file entered by the user should it exist
	public void fileNumbers(String fileName) {
		Scanner lineReader;
		try {
			lineReader = new Scanner(new File(fileName));
			do {
				numItems = lineReader.nextInt();
				for (int i = 0; i < numItems; i++) {
					numbers[i] = lineReader.nextFloat();
				}
			} while (lineReader.hasNext());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Creates and writes to a new file of your choice the numbers inside the array
	public void writeFile(String fileName) {

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(numItems);
			for (int i = 0; i < numItems; i++) {
				printWriter.println(numbers[i].toString());
			}
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
