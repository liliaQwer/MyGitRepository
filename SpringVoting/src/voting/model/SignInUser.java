package voting.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SignInUser {
	
	@Size(min=3, max=15)
	@Email
	@NotEmpty
	private String email;
	
	@Size(min=3, max=10)
	@NotEmpty
	private String password="";	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

