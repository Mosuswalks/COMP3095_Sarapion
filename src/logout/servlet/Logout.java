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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				cookie.setMaxAge(-1);
					
				
			}
			System.out.println("Deleted Cookies");
			response.sendRedirect("Login");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
