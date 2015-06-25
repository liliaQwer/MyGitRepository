package voting.model;

import javax.validation.constraints.Size;

import voting.annotations.Email;
import voting.annotations.PasswordMatches;

@PasswordMatches
public class SignUpUser {
	
	@Size(min=3, max=15)
	@Email
	private String email;
	
	@Size(min=3, max=10)
	private String password="";
	
	@Size(min=3, max=10)
	private String passwordConfirm="";
	
	@Size(min=8, max=10)
	private String birthDate;	
	
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}	

}
