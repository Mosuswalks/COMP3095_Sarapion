/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Servlet which handles the logging out of users.

********************************************************************************************************/


package logout.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;



@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logout() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		request.getAttribute("user");
		try {
			session.invalidate();
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie: cookies) {
				if(cookie.getPath() == "/COMP3095_Sarapion") {
					cookie.setMaxAge(-1);
				}

			}
			System.out.println("Deleted Cookies");
			request.getRequestDispatcher("login").forward(request, response);;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
