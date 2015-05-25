package voting.model;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SignUpUser {
	
	@Size(min=3, max=15)
	@Email
	@NotEmpty
	private String email;
	
	@Size(min=3, max=10)
	@NotEmpty
	private String password="";
	
	@Size(min=3, max=10)
	@NotEmpty
	private String passwordConfirm="";
	
	@Size(min=8, max=10)
	@NotEmpty
	private String birthDate;
	
	@AssertFalse(message="passwords should be equal")
	private boolean samePasswords;
	
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
	
	public boolean isSamePasswords(){
		System.out.println("pasw="+password+" pasw2="+passwordConfirm+ " result= "+password.equals(passwordConfirm));
		return password.equals(passwordConfirm);
	}
	

}
