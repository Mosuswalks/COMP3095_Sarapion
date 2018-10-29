/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Servlet which handles the registering new users to our site.

********************************************************************************************************/

package register.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.*;
import utilities.*;



@WebServlet("/Register")
public class Register extends HttpServlet {
       
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Register() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("passwordConfirmation");
		String termsCheckbox = request.getParameter("termConfirm");
		
		
		HashMap<String, String> userCred = new HashMap<String, String>();
		userCred.put("fName", firstName);
		userCred.put("lName", lastName);
		userCred.put("addr", address);
		userCred.put("email", email);
		userCred.put("password", password);
		userCred.put("passwordConfirmation", passwordConfirmation);
		userCred.put("termsCheckbox",termsCheckbox);
		
		List<String> formErrors = Helper.validateRegistration(userCred);
		
		if(formErrors.size() == 0) {
			try {
				
				DatabaseAccess.registerUser(userCred);
				
				
				RegistrationEmail.sendEmail(userCred.get("email"), userCred.get("fName"),userCred.get("lName"));
				
				request.setAttribute("email", email);
				request.getRequestDispatcher("jsp/success_confirmation.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("formErrors", formErrors);
			request.setAttribute("formInfo", userCred);
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
			
		}
	}

}