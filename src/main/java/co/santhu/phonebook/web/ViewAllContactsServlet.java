package co.santhu.phonebook.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.santhu.phonebook.entity.Contact;
import co.santhu.phonebook.entity.User;
import co.santhu.phonebook.service.ContactService;

@WebServlet("/view-all-contacts")
public class ViewAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//we should get the userId from the session
		User user = (User) request.getSession().getAttribute("user");
		ContactService service = new ContactService();
		request.setAttribute("contacts", service.getAllContacts(user.getId()));
		request.getRequestDispatcher("/WEB-INF/views/showAllContacts.jsp").forward(request, response);
	}
}
