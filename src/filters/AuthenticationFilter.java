/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Filter for controlling access to restricted areas of the site.

********************************************************************************************************/

package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;

		
		if(request.getRequestURI().startsWith("/COMP3095_Sarapion/dashboard") ||
				request.getRequestURI().startsWith("/COMP3095_Sarapion/jsp/dashboard.jsp") ||
				request.getRequestURI().startsWith("/COMP3095_Sarapion/jsp/tab1.jsp") ||
				request.getRequestURI().startsWith("/COMP3095_Sarapion/jsp/tab2.jsp") ||
				request.getRequestURI().startsWith("/COMP3095_Sarapion/jsp/tab3.jsp") ||
				request.getRequestURI().startsWith("/COMP3095_Sarapion/jsp/tab4.jsp")) {
			
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("username") == null) {
				request.getRequestDispatcher("/Login").forward(request, arg1);
			}
		}
		arg2.doFilter(request, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
}
