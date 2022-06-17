import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

/**The purpose of this class is to add some functionality to the inventory class with adding support for expired foods.
 * farm supplier by calling super()
* @author Justin Warkus-Fortin (040966794)
 * Assignment 3
 * August 5th 2020
 * @version 1.0
 * @since 1.8
 */
public class InventoryItem implements Comparable<InventoryItem>, Iterator<LocalDate> {
	protected int itemQuantityInStock;
	private FoodItem foodItem;
	private Queue<LocalDate> expiries;

	public InventoryItem(FoodItem foodItem) {
		this.itemQuantityInStock = 0;
		this.foodItem = foodItem;
		this.expiries = new LinkedList<>();
	}

	public int getItemCode() {
		// TODO Auto-generated method stub
		return foodItem.getItemCode();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LocalDate next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(InventoryItem itemCompare) {
		// TODO Auto-generated method stub
		return (this.foodItem.itemCode - itemCompare.getItemCode());
	}

	public boolean addItem(Scanner scan) {
		Pattern pattern = Pattern.compile("^\\d+");
		// Pattern that doesn't allow any negative numbers
		System.out.print("Enter quantity for the item: ");
		String strQuant = scan.next();
		while (!pattern.matcher(strQuant).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter quantity for the item: ");
			strQuant = scan.next();
		}
		this.itemQuantityInStock = Integer.parseInt(strQuant);
		System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): ");
		try {
			String date = scan.next();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (date.contentEquals("none") || date.contentEquals("None")) {
				for (int i = 0; i < itemQuantityInStock; i++) {
					expiries.add(LocalDate.MAX);
				}
			} else {
				for (int i = 0; i < itemQuantityInStock; i++) {
					expiries.add(LocalDate.parse(date, format));
				}
			}
		} catch (DateTimeParseException e) {
			System.out.print("Invalid date\n");
		} catch (InputMismatchException f) {
			System.out.print("Invalid date\n");
		} catch (NumberFormatException g) {
			System.out.print("Invalid date\n");
		}
		return true;
	}

	public boolean inputCode(Scanner scan) {
		return foodItem.inputCode(scan);
	}

	public void printExpiry() {
		System.out.print(this.toString());
		System.out.print("\nExpiry details: ");

		Iterator<LocalDate> expiryDates = expiries.iterator();
		LocalDate dateCheck = expiryDates.next();
		LocalDate previousDateCheck = dateCheck;

		System.out.print("\n" + dateCheck + ": " + Collections.frequency(expiries, dateCheck));

		while (expiryDates.hasNext()) {
			dateCheck = expiryDates.next();
		}
		if (dateCheck != previousDateCheck) {
			System.out.print("\n" + dateCheck + ": " + Collections.frequency(expiries, dateCheck));
			previousDateCheck = dateCheck;
		}
	}

	public void removeExpiredItems(LocalDate today) {
		Iterator<LocalDate> dateCheck = expiries.iterator();
		LocalDate date;

		while (dateCheck.hasNext()) {
			date = dateCheck.next();
			if (date.equals(today)) {
				dateCheck.remove();
				itemQuantityInStock--;
			}
		}
	}

	public boolean updateQuantity(Scanner scan, int amount) {
		itemQuantityInStock += amount;
		if (amount < 0) {
			for (int i = 0; i < -(amount); i++) {
				expiries.remove();
			}
		} else {
			System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): ");
			try {
				String date = scan.next();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				if (date.contentEquals("none") || date.contentEquals("None")) {
					for (int i = 0; i < itemQuantityInStock; i++) {
						expiries.add(LocalDate.MAX);
					}
				} else {
					for (int i = 0; i < itemQuantityInStock; i++) {
						expiries.add(LocalDate.parse(date, format));
					}
				}
			} catch (DateTimeParseException e) {
				e.getLocalizedMessage();
			}
		}
		return true;
	}
	
	public String toString() {
		return foodItem.toString()+" qty: "+itemQuantityInStock;
	}

}
