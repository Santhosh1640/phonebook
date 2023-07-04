package co.santhu.phonebook.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.santhu.phonebook.entity.User;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Moved the below code to LoginCheckFilter servlet
		User user = (User) request.getSession().getAttribute("user");
		
		//if user has not logged in, redirect to home page
		if(user==null) {
			response.sendRedirect("./login");
			return;
		} */
		
		//else redirect to dashboard
		request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
	}

}
