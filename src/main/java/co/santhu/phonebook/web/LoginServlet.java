package co.santhu.phonebook.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.santhu.phonebook.entity.User;
import co.santhu.phonebook.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		//if user has logged in, redirect to dashboard
		if(user!=null) {
			response.sendRedirect("./dashboard");
			return;
		}
		//else redirect to login page
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.Read inputs from request
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		Map<String, String> errors = new HashMap<String, String>();
		User user = service.login(email, password, errors);
		
		if(errors.size()>0) {
			//Store it in errors
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		else {  //If there are no errors
			//Store this in a logged in users in the session
			//and redirect to dashboard
			request.getSession().setAttribute("user", user);
			response.sendRedirect("./dashboard");
		}
			
		
	}

}
