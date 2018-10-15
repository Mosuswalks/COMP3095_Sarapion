package utilities;

import java.util.regex.Pattern;
import java.util.*;

public class helper {
	
	public static boolean validName(String name) {
		boolean nameMatch = Pattern.matches("[a-zA-Z]", name);
		return nameMatch;
	}
	
	
	public static boolean validEmail(String email) {
		boolean emailMatch = Pattern.matches("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b", email);
		return emailMatch;
	}
	
	public static boolean validPassword(String password) {
		boolean passwordMatch = Pattern.matches("^(?=.*\\d)(?=.*\\W)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,12}$", password);
		return passwordMatch;
	}
	
	
	public static boolean isEmpty(String value) {
		return value.isEmpty() || (value.trim().length()) == 0;
	}
	
	
	public static List<String> validateRegistration(HashMap<String, String> userCred) {
		
		List<String> formErrors = new ArrayList<String>();
		
		if(isEmpty(userCred.get("fName")) || isEmpty(userCred.get("lName"))) {
			formErrors.add("First and/or Last Name cannot be empty.");
			
		}
		
		if(!validEmail(userCred.get("email"))) {
			formErrors.add("Invalid Email Address.");
		}
		
		if(!validPassword(userCred.get("password"))) {
			formErrors.add("Passwords must be between 6-12 characters and contain 1 uppercase letter and 1 special character(ex. !*&$).");
		}
		
		if(userCred.get("password") == userCred.get("passwordConfirm")){
			formErrors.add("Passwords do not match.");
		}
		return formErrors;
	}
	
	
}
