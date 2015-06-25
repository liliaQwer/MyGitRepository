package voting.model;

import javax.validation.constraints.Size;

import voting.annotations.Email;

public class SignInUser {
	
	@Size(min=3, max=15)
	@Email
	private String email;
	
	@Size(min=3, max=10)
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

