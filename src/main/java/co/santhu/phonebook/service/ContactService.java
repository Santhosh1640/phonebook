package co.santhu.phonebook.service;

import java.io.IOException;
import java.security.Permission;
import java.util.List;
import java.util.Map;

import co.santhu.phonebook.dao.ContactDao;
import co.santhu.phonebook.dao.DaoFactory;
import co.santhu.phonebook.entity.Contact;

public class ContactService {

	public Contact addNewContact(Contact c, Map<String, String> errors) throws IOException {

		if (c.getFirstname().trim().length() == 0) {
			errors.put("name", "Firstname cannot be empty");
		} else if (c.getFirstname().trim().length() < 3) {
			errors.put("name", "Firstname should be atleast 3 characters");
		}

		if (c.getEmail().trim().length() == 0) {
			errors.put("email", "Email cannot be empty");
		}

		if (c.getPhone().trim().length() == 0) {
			errors.put("email", "Phone number cannot be empty");
		}

		if (errors.size() > 0) {
			return c;
		}

		ContactDao dao = DaoFactory.getContactDao();

		Contact c1 = dao.getContactByEmail(c.getEmail());
		// If there is already a contact with this email
		if (c1 != null) {
			errors.put("email", "There is already a contact for this email");
		}

		c1 = dao.getContactByPhone(c.getPhone());
		// If there is already a contact with this phone
		if (c1 != null) {
			errors.put("email", "There is already a contact for this phone number");
		}

		if (errors.size() > 0) {
			return c;
		}

		dao.createContact(c);

		return c;
	}

	public Contact getContactById(Integer id, Integer userId) throws IOException {

		ContactDao dao = DaoFactory.getContactDao();
		return dao.getContact(id, userId);
	}

	public List<Contact> getAllContacts(Integer userId) throws IOException {

		ContactDao dao = DaoFactory.getContactDao();
		return dao.getAllContacts(userId);
	}

	public void updateContact(Integer id, Contact c, Map<String, String> errors) throws IOException {
		c.setId(id);
		
		if (c.getFirstname().trim().length() == 0) {
			errors.put("name", "Firstname cannot be empty");
		} else if (c.getFirstname().trim().length() < 3) {
			errors.put("name", "Firstname should be atleast 3 characters");
		}

		if (c.getEmail().trim().length() == 0) {
			errors.put("email", "Email cannot be empty");
		}

		if (c.getPhone().trim().length() == 0) {
			errors.put("email", "Phone number cannot be empty");
		}

		if (errors.size() > 0) {
			return;
		}
		
		ContactDao dao = DaoFactory.getContactDao();
		dao.updateContact(c);
	}
	
	public void deleteContactById(Integer id, Integer userId, Map<String,String> errors) throws IOException {
		ContactDao dao = DaoFactory.getContactDao();
		Contact c1 = dao.getContact(id, userId);
		
		if(c1==null) {
			errors.put("userId", "Permission denied for deleting this contact");
			return;
		}
		
		dao.deleteContact(id);
	}


}
