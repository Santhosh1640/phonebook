package co.santhu.phonebook.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.santhu.phonebook.entity.Contact;
import co.santhu.phonebook.entity.User;
import co.santhu.phonebook.service.ContactService;

@WebServlet("/edit-contact-details")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("id");
		if (input == null) {
			response.sendRedirect("./");
			return;
		}

		Integer id = new Integer(input);
		ContactService service = new ContactService();
		User user = (User) request.getSession().getAttribute("user");

		Contact contact = service.getContactById(id, user.getId());
		request.setAttribute("contact", contact);
		request.setAttribute("title", "Edit contact details");
		request.getRequestDispatcher("/WEB-INF/views/contactForm.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String input = request.getParameter("id");
		if (input == null) {
			response.sendRedirect("./");
			return;
		}

		Integer id = new Integer(input);
		
		// 1.Read inputs from request
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String avatar = request.getParameter("avatar");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		String state = request.getParameter("state");
		String country = request.getParameter("country");

		// 2.Make use of model function
		// Save the contact into the database
		Contact c = new Contact();

		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);
		c.setPhone(phone);
		c.setAvatar(avatar);
		c.setAddress(address);
		c.setCity(city);
		c.setPincode(pincode);
		c.setState(state);
		c.setCountry(country);

		User user = (User) request.getSession().getAttribute("user");
		c.setUserId(user.getId());

		// Pass this to the service layer to add this contact
		ContactService service = new ContactService();
		Map<String, String> errors = new HashMap<String, String>();
		service.updateContact(id, c, errors);
		
		if (errors.size() > 0) {
			// Store it in errors
			request.setAttribute("errors", errors);
			request.setAttribute("contact", c);
			request.getRequestDispatcher("/WEB-INF/views/contactForm.jsp").forward(request, response);
		} else { // If there are no errors
			// Store this in a logged in users in the session
			// and redirect to dashboard
			response.sendRedirect("./view-contact-details?id=" + c.getId());
		}
	}

}
