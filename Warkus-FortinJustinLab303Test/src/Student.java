import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
	private int studentNumber;
	private String studentName;
	private float balance;
	
	public Student() {
		this.studentNumber = 0;
		this.studentName = "Unknown";
		this.balance = 0;
	}
	public boolean addStudent(Scanner scan) {
		System.out.print("Please Enter the Student's Name: ");
		this.studentName = scan.nextLine();
		System.out.print("Please Enter the Student Number: ");
		String studentNumbers = scan.nextLine();
		Pattern pattern = Pattern.compile("-?\\d+");
		if (!pattern.matcher(studentNumbers).matches()) {
			System.out.print("Incorrect format");
			return false;
		}
		this.studentNumber = Integer.parseInt(studentNumbers);
		System.out.print("Please Enter the Student's Balance: ");
		String balances = scan.nextLine();
		Pattern pattern2 = Pattern.compile("(\\d+)?(\\.\\d+)?");
		if(!pattern2.matcher(balances).matches()) {
			System.out.print("Incorrect format\n");
			return false;
		}
		this.balance = Float.parseFloat(balances);
		return true;
	}
	public String toString() {
		return "Student #: "+studentNumber+", Name: "+ studentName+ ", Balance: $"+balance;
		
	}
	public int getStudentNumber() {
		return studentNumber;
	}
}
