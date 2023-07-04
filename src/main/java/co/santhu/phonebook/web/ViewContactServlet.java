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

@WebServlet("/view-contact-details")
public class ViewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String input = request.getParameter("id");
		if(input==null) {
			response.sendRedirect("./");
			return;
		}
		
		Integer id = new Integer(input);
		User user = (User) request.getSession().getAttribute("user");
		//We need to Make use of the service
		//Collect the contact object, store it in the request scope and forward the request to JSP
		ContactService service = new ContactService();
		
		Contact c = service.getContactById(id, user.getId());
		//Store
		request.setAttribute("contact", c);
		//forward to JSP
		request.getRequestDispatcher("/WEB-INF/views/showContact.jsp").forward(request, response);
	}
}
