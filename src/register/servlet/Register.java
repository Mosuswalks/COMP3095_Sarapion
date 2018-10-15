package register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
		

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		List<String> formErrors = helper.validateRegistration(userCred);
		
		if(formErrors.size() == 0) {
			try {
				DatabaseAccess.registerUser(userCred);
				System.out.println("Entry Added");
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			
			request.setAttribute("formErrors", formErrors);
			request.setAttribute("formInfo", userCred);
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
			
			for(String error: formErrors) {
				System.out.println(error);
			}
			
		}
	}

}
