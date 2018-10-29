/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Servlet that handles user authentication.

********************************************************************************************************/


package login.servlet;
import java.io.IOException;
import java.sql.Connection;
import utilities.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Collect Form Data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String reCaptcha = request.getParameter("g-recaptcha-response");
		// 
		if(VerifyReCaptcha.verify(reCaptcha)) {
			
			try {
				String isValidUser = DatabaseAccess.validateUser(username,password);
				
				
				if(isValidUser != null){
					System.out.println(isValidUser);
					//Setup HTTP Session
					HttpSession session = request.getSession();
					
					// Set the username as an attribute
					session.setAttribute("username", username);
					session.setAttribute("firstName", isValidUser);
					session.setMaxInactiveInterval(60 * 5);
					
					
					// Forward to the dashboard page
					request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
					
				}
				else {
					String loginError = "Invalid Credentials. Please try again.";
					request.setAttribute("error", loginError);
					request.getRequestDispatcher("login").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
		
	}
}