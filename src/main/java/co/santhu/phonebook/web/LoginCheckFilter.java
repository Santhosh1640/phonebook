package co.santhu.phonebook.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import co.santhu.phonebook.entity.User;

@WebFilter(urlPatterns = {"/dashboard", "/add-contact", "/view-contact-details", "/view-all-contacts", 
		"/edit-contact-details", "/delete-contact-details"})
public class LoginCheckFilter implements Filter {
	private static final long serialVersionUID = 1L;
       
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    	throws IOException, ServletException{
    	
    	HttpServletRequest req = (HttpServletRequest) request;
    	HttpServletResponse resp = (HttpServletResponse) response;
    	
    	User user = (User) req.getSession().getAttribute("user");
    	
    	if(user==null) {
    		resp.sendRedirect("./login");
    		return;
    	}
    	chain.doFilter(request, response);
    }

}
