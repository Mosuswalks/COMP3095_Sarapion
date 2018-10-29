/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Helper Methods for server side input validation.

********************************************************************************************************/

package utilities;

import java.util.regex.Pattern;
import java.util.*;
import utilities.DatabaseAccess;

public class Helper {
	
	public static boolean validName(String name) {
		boolean nameMatch = Pattern.matches("[a-zA-Z]+", name);
		return nameMatch;
	}
	
	
	public static boolean validEmail(String email) {
		boolean emailMatch = Pattern.matches("^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@(([0-9a-zA-Z])+([-\\w]*[0-9a-zA-Z])*\\.)+[a-zA-Z]{2,9})", email);
		return emailMatch;
	}
	
	public static boolean validPassword(String password) {
		boolean passwordMatch = Pattern.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{6,12}", password);
		return passwordMatch;
	}
	
	
	public static boolean isEmpty(String value) {
		if(validName(value)) {
			return value.isEmpty() || (value.trim().length()) == 0;
		}
		return false;
	}
	
	
	public static List<String> validateRegistration(HashMap<String, String> userCred) {
		
		List<String> formErrors = new ArrayList<String>();
		
		
		try {
			if(!DatabaseAccess.isUniqueUser(userCred.get("email"))) {
				formErrors.add("The email provided is already in use.");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(isEmpty(userCred.get("fName")) || isEmpty(userCred.get("lName"))) {
			formErrors.add("First and/or Last Name cannot be empty and contain only alphabetical letters.");
		}
		
		
		if(!validEmail(userCred.get("email"))) {
			formErrors.add("Invalid Email Address.");
		}
		
		if(!validPassword(userCred.get("password"))) {
			formErrors.add("Passwords must be between 6-12 characters and contain 1 uppercase letter and 1 special character(ex. !*&$).");
		}
		
		if(!Objects.equals(userCred.get("password"), userCred.get("passwordConfirmation"))) {
			formErrors.add("Passwords do not match.");
		}
		
		if(!Objects.equals(userCred.get("termsCheckbox"), "true")) {
			formErrors.add("You must agree to the terms and conditions.");
		}
		
		return formErrors;
	}
	
	
}
