import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random; //needed for random password generation

/**
 * CredentialService inherit from Employee class. Why this?
 * 
 * Normally a service class would merely provide password generation
 * functionality to Employee class, and the actual employee details along with
 * password hash would be stored under employee class.
 * 
 * I was not sure creation of extra data members was allowed in the problem
 * statement, so as a quick workaround, I stored the password in credential
 * service, and built in the main logic to directly access the service, which
 * calls employee creation as and when required.
 * 
 * The other thing was that employee name is hardcoded. It can be easily made
 * configurable, but the sample output had no such mechanism.
 * 
 * 
 */
public class CredentialService {

	/**
	 * Store password, email within credential service. All other employee details
	 * stored in Employee class from which CredentialService Inherits.
	 */
	private static Dictionary<Integer, String> passDb = new Hashtable<Integer, String>(); // map to store all passwords

	public void generatePassword(int id) {
		passDb.put(id, generateRandomString());
	};

	public String showCredentials(int id) {
		return passDb.get(id);
	};

	private static String generateRandomString() {

		final int length = 9;

		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String special = "!@#$%^&*()-_=+]}[{;:/?.>,<";
		String nos = "1234567890";
		String passwordSearchSpace = upperCase + lowerCase + special;

		Random random = new Random();

		String password = "";

		for (int i = 0; i < length; i++) {
			password += passwordSearchSpace.charAt(random.nextInt(passwordSearchSpace.length()));
		}

		return password;
	}
}
