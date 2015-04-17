package voting.util;

import javax.validation.constraints.Size;

public class User {
	@Size(min=3, max=20)
	private String email;
	
	@Size(min=3, max=20)
	private String password;
	
	@Size(min=3, max=20)
	private String birthDate;
	
	private int role;
	
	public User (){
		
	}
	
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
