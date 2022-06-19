import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

//base class - Employee with personnel details 

public class Employee {

	// dictionary for storing departments names, short names (based on example email
	// of Harshit) mapped to integers

	public Dictionary<Integer, String[]> dictDepartments;

	/**
	 * Protected class members so they become private upon inheritance and can no
	 * longer be inherited beyond CredentialService class
	 */
	private static int idCount = 0; // static ID counter

	private int id; //
	private int department;
	private String firstName;
	private String lastName;
	private String email;
	private static String company = "abc"; // assuming company is same for all employees

	private static CredentialService cs = new CredentialService(); // one credential service for all employee objects

	// hardcoded string "Abc" but can be made configurable in a real program

	public Employee(String firstName, String lastName) {
		this.initDictionary();

		this.id = ++idCount;
		this.firstName = firstName;
		this.lastName = lastName;

		Scanner sc = new Scanner(System.in);

		// hardcoded message as per problem statement
		System.out.println("Please enter the department from the following:");
		System.out.print("1. Technical\n2. Admin\n3. Human Resource\n4. Legal\nChoice: ");

		this.department = sc.nextInt();
		this.generateEmailAddress();

		cs.generatePassword(this.id);
	}

	// hardcoded dictionary as size of program is small. A more scaleable version
	// would be reading off of an sql database
	private void initDictionary() {
		this.dictDepartments = new Hashtable<Integer, String[]>();
		dictDepartments.put(1, new String[] { "Technical", "tech" });
		dictDepartments.put(2, new String[] { "Admin", "admin" });
		dictDepartments.put(3, new String[] { "Human Resource", "hr" });
		dictDepartments.put(4, new String[] { "Legal", "legal" });
	}

	private void generateEmailAddress() {
//		System.out.println((this.dictDepartments.get(this.department))[1]);

		this.email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@"
				+ (this.dictDepartments.get(this.department))[1] + "." + this.company + ".com";
	};

	public void showEmployeeDetails() {
		System.out.println("Dear " + firstName + ", your generated credentials are as follows");
		System.out.println("Email    -->    " + this.email);
		System.out.println("Password -->    " + cs.showCredentials(this.id));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter employee name in <firstname> <lastname> format");
		Employee emp = new Employee(sc.next(), sc.next());
		emp.showEmployeeDetails();
	}

}
