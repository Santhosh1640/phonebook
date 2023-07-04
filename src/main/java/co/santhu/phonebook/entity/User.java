package co.santhu.phonebook.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Date createdAt = new Date();
	
	/*This is a constructor for name, email and password because
	  it becomes easy for service layer to create an object quickly*/
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
}
