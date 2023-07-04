package co.santhu.phonebook.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Contact {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String avatar;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private Integer userId;
	private Date createdAt;

}
