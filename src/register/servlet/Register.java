
package register.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.*;
import utilities.*;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirmation");
		
		
		HashMap<String, String> userCred = new HashMap<String, String>();
		userCred.put("fName", firstName);
		userCred.put("lName", lastName);
		userCred.put("addr", address);
		userCred.put("email", email);
		userCred.put("password", password);
		userCred.put("passwordConfirm", passwordConfirm);
		
		List<String> formErrors = Helper.validateRegistration(userCred);
		
		if(formErrors.size() == 0) {
			try {
				
				DatabaseAccess.registerUser(userCred);
				
				//Setup HTTP Session
				HttpSession session = request.getSession();
				
				// Set the username as an attribute
				session.setAttribute("username", email);
				session.setMaxInactiveInterval(60 * 5);
				
				RegistrationEmail.sendEmail(userCred.get("email"), userCred.get("fName"));
				
				request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
				
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