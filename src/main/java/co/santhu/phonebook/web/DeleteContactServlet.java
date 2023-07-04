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

@WebServlet("/delete-contact-details")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input = request.getParameter("id");
		
		if(input==null) {
			response.sendRedirect("./");
			return;
		}
		
		Integer id = new Integer(input);
		ContactService service = new ContactService();
		User user = (User) request.getSession().getAttribute("user");
		
		Contact c1 = service.getContactById(id, user.getId());
		request.setAttribute("contact", c1);
		request.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(request, response);	
	
	}
	
	//We also need doPost because when user clicks on Delete button it should not be deleted right away without safety caution
	// For example when we click on delete it should ask like "Are you sure you want to delete if yes click yes" like that.
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = new Integer(request.getParameter("id"));
		String confirm = request.getParameter("confirm");
		
		User user = (User) request.getSession().getAttribute("user");
		ContactService service = new ContactService();
		if(confirm.equals("PERMANENTLY DELETE")==false) {
			//If it false, it still stores the details 
			Contact c1 = service.getContactById(id, user.getId());
			request.setAttribute("contact", c1);
			request.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(request, response);	
		}
		else {
			Map<String, String> errors = new HashMap<String, String>();
			service.deleteContactById(id, user.getId(), errors);
			if(errors.size()==0) { //If no errors
				response.sendRedirect("./"); //After deletion
			}else { 
				//If we face errors
				//First store that error
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(request, response);
			}
		}
		
	}
}
