import java.util.Scanner;

public class Lab303Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String choice = "";
		Student s = new Student();
		CollegeRegistrar cr = new CollegeRegistrar();
		while (choice != "5") {
			System.out.print("Please select one of the following:\n1: Add Student to College Registrar\n"
					+ "2: Display Students in the Registrar\n3: Set College Registrar Name\n4: Search for a student\n5: Exit\n>");
			choice = scan.next();
			scan.nextLine();
			switch (choice) {
			case "1":
				cr.addStudents(scan);
				break;

			case "2":
				cr.selectionSort();
				
				System.out.print("College Registrar Information:\nName: " + cr.getName() + "\nStudents List:\n"
						+ cr.toString() + "\n");
				break;

			case "3":
				cr.setName(scan);
				break;
			case "4":
				cr.searchStud(scan);
				break;
			case "5":
				System.out.print("Exiting...");
				choice="5";
				break;
			default: 
				System.out.print("Invalid choice\n");
			}
		}
	}
}
