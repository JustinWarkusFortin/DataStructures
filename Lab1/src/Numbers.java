
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Justin-Thomas Warkus-Fortin
 * Student Number:  040966794
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {
	
	private Float[] numbers;
	int numItems = 0;

	public Numbers() {
		setNumbers(new Float[10]);
		numItems = 0;
	}
	public Numbers(int size) {
		setNumbers(new Float[size]);
		numItems = 0;
	}
	public void addValue(Scanner keyboard) {
		try {
			getNumbers()[numItems] = keyboard.nextFloat();
			numItems++;
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Array Full!\n");
		}catch (InputMismatchException e) {
			System.out.print("Invalid symbol!\n");
		}
	}
	public float calcAverage() {
		float average = 0;
		if(numItems != 0) {
			for(int i = 0; i < numItems; i++) {
				average += getNumbers()[i];
			}
			average = average/numItems;
		return (float) average;
		}
		return 0.0f;
	}
	public String toString() {
		String words = "";
		for(int i = 0; i < numItems; i++) {
			words += getNumbers()[i] + "\n";
		}
		return words; 
	}
	public double calcMedian() {
		double median = 0;
		float[] arrayToSort = new float[numItems];
		for(int i=0;i<numItems;i++) {
			arrayToSort[i] += (float) numbers[i];
		}
		for (int i = 0; i < arrayToSort.length; i++) {     
            for (int j = i+1; j < arrayToSort.length; j++) {     
               if(arrayToSort[i] > arrayToSort[j]) {    
                   double temp = arrayToSort[i];    
                   arrayToSort[i] = arrayToSort[j];    
                   arrayToSort[j] = (float) temp;    
               }     
            }
		}
		if(numItems % 2 > 0) {
			median = arrayToSort[arrayToSort.length/2];
		return median;
		}else if(numItems % 2 == 0) {
			median = arrayToSort[arrayToSort.length/2] + arrayToSort[(arrayToSort.length/2) -1];
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
}
