import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	@Override
	public String toString() {
		String words = "";
		for (int i = 0; i < numItems; i++) {
			words += getNumbers()[i] + "\n";

		}
		return words;
	}

	public double calcMedian() {
		double median = 0;
		float[] arrayToSort = new float[numItems];
		for (int i = 0; i < numItems; i++) {
			arrayToSort[i] += (float) numbers[i];
		}
		for (int i = 0; i < arrayToSort.length; i++) {
			for (int j = i + 1; j < arrayToSort.length; j++) {
				if (arrayToSort[i] > arrayToSort[j]) {
					double temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = (float) temp;
				}
			}
		}
		if (numItems == 0) {
			return 0.0;
		} else if (numItems % 2 > 0) {
			median = arrayToSort[arrayToSort.length / 2];
			return median;
		} else if (numItems % 2 == 0) {
			median = arrayToSort[arrayToSort.length / 2] + arrayToSort[(arrayToSort.length / 2) - 1];
			median /= 2;
			return median;
		}
		return 0.0;
	}

	public Float[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Float[] numbers) {
		this.numbers = numbers;
	}

	public void fileNumbers(String fileName) {
		Scanner lineReader;
		try {
			lineReader = new Scanner(new File(fileName));
			do {
				numItems = 0;
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

	public String bubbleSort() {
		// copy to a new array
		float[] arrayToSort = new float[numItems];
		for (int i = 0; i < numItems; i++) {
			arrayToSort[i] += (float) numbers[i];
		}
		
		for (int i = 0; i < arrayToSort.length; i++) {
			for (int j = i + 1; j < arrayToSort.length; j++) {
				if (arrayToSort[i] > arrayToSort[j]) {
					double temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = (float) temp;
				}
			}
		}
		// print out all the numbers sorted
		String words = "";
		for (int i = 0; i < numItems; i++) {
			words += arrayToSort[i] + ", ";
		}
		return words;
	}

	public String selectionSort() {
		// copy to a new array
		float[] arrayToSort = new float[numItems];
		for (int i = 0; i < numItems; i++) {
			arrayToSort[i] += (float) numbers[i];
		}
		for (int i = 0; i < arrayToSort.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arrayToSort.length; j++)
				if (arrayToSort[j] < arrayToSort[min])
					min = j;
			float temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[min];
			arrayToSort[min] = temp;
		}
		// print out all the numbers sorted
		String words = "";
		for (int i = 0; i < numItems; i++) {
			words += arrayToSort[i] + " ";
		}
		return words;
	}

	public String insertionSort() {
		// copy to a new array
		float[] arrayToSort = new float[numItems];
		for (int x = 0; x < numItems; x++) {
			arrayToSort[x] += (float) numbers[x];
		}
		for (int i = 1; i < arrayToSort.length; i++) {
			float index = arrayToSort[i];
			int j = i;
			while (j > 0 && arrayToSort[j - 1] > index) {
				arrayToSort[j] = arrayToSort[j - 1];
				j--;
			}
			arrayToSort[j] = index;

		}
		// print out all the numbers sorted
		String words = "";
		for (int i = 0; i < numItems; i++) {
			words += arrayToSort[i] + ", ";
		}
		return words;
	}

}
