package co.santhu.phonebook.service;

import java.io.IOException;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import co.santhu.phonebook.dao.DaoFactory;
import co.santhu.phonebook.dao.UserDao;
import co.santhu.phonebook.entity.User;

public class UserService {
	
	public User registerUser(
			String name, 
			String email, 
			String password, 
			String cPassword, 
			Map<String, String> errors) throws IOException {
		
		if(name.trim().length()==0) {
			errors.put("name", "Name cannot be empty");
		}
		else if(name.trim().length()<3) {
			errors.put("name", "Name should be atleast 3 characters");
		}
		
		if(email.trim().length()==0) {
			errors.put("email", "Email cannot be empty");
		}
		
		if(password.trim().length()==0) {
			errors.put("password", "Password cannot be empty");
		}
		
		if(password.equals(cPassword)==false) {
			errors.put("confirmPassword", "Passwords don't match");
		}
		
		//Check whether there is a record for this particular email in our database
		UserDao dao = DaoFactory.getUserDao();
		User user = dao.getUserByEmail(email);
		if(user!=null) {
			errors.put("email", "This email is already registered");
		}
		if(errors.size()>0) {
			return null;
		}
		
		//Encrypt the password
		password = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		user = new User(name, email, password);
		dao.createUser(user);
		return user;
	}

	public User login(String email, String password, Map<String, String> errors) throws IOException {

		if(email.trim().length()==0) {
			errors.put("email", "Email cannot be empty");
		}
		
		if(password.trim().length()==0) {
			errors.put("password", "Password cannot be empty");
		}
		
		if(errors.size()>0) {
			return null;
		}
		
		UserDao dao = DaoFactory.getUserDao();
		User user = dao.getUserByEmail(email);
		if(user==null) {
			errors.put("email", "Invalid email/password");
		}
		else {
			//Check if password is correct
			boolean result = BCrypt.checkpw(password, user.getPassword());
			if(result==false) {
				errors.put("password", "Invalid email/password");
			}
		}
		
		if(errors.size()>0) {
			return null;
		}
		
		return user;
	}
}
