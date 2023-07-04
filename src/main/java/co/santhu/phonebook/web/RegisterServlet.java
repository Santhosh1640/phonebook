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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * In case if the user has already logged in, we don't want the user to register
		 * again so, we have to check that case too
		 */
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			response.sendRedirect("./dashboard");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.Read inputs from request
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cPassword = request.getParameter("c_password");

		// 2.Make use of model function
		UserService service = new UserService();
		Map<String, String> errors = new HashMap<String, String>();
		User user = service.registerUser(name, email, password, cPassword, errors);

		if (errors.size() > 0) {
			// Store it in errors
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		} else { // If there are no errors
			// Store this in a logged in users in the session
			// and redirect to dashboard
			request.getSession().setAttribute("user", user);
			response.sendRedirect("./dashboard");
		}
	}

}
