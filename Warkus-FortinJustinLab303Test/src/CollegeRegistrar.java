import java.util.Scanner;

public class CollegeRegistrar {
	private Student[] students;
	private String name;
	private int numStudents = 0;

	public CollegeRegistrar() {
		students = new Student[20];
		this.name = "Unknown";
	}

	public String setName(Scanner scan) {
		System.out.print("Set College Registrar name: ");
		this.name = scan.nextLine();
		return name;
	}

	public String toString() {
		
		String words = "";
		for (int i = 0; i < numStudents; i++) {
			words += students[i] + "\n";
		}
		return words;

	}

	public boolean addStudents(Scanner scan) {
		students[numStudents] = new Student();
		if(students[numStudents].addStudent(scan) == false) {
			return false;
		}else {
			numStudents++;
			return true;
		}
	}
	public String getName() {
		return name;
	}
	public void selectionSort() {
		
		for(int i = 0; i < numStudents-1; i++) {
			int min = 1;
			for(int j=i+1;j<numStudents;j++) {
				if(students[j].getStudentNumber() < students[min].getStudentNumber()) {
					min = j;
				}
				Student temp = students[i];
				students[i] = students[min];
				students[min] = temp;
			}
		}
	}
	
	public boolean searchStud(Scanner scan) {
		System.out.print("Please enter the student number to search for: ");
        String input = scan.nextLine();
        int num;

        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        for (int i = 0; i < numStudents; i++) {
            if (students[i].getStudentNumber() == num) {
                System.out.println("Student found at index " + i);
                System.out.println(students[i].toString());
                return true;
            }
        }

        System.out.println("Student not found in College Registrar");
        return false;

	}
	
}
