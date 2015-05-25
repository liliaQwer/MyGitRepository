package voting.util;

import java.util.ArrayList;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@Size(min=3, max=15)
	@Email
	@NotEmpty
	private String email;
	
	@Size(min=3, max=10)
	@NotEmpty
	private String password;
	
	@Size(min=6, max=10)
	private String birthDate;
	
	private ArrayList<Roles> roles;
	
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
	
	String name="Ivan";
	String surname="Ivanov";
	int age=1;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<Roles> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<Roles> roles) {
		this.roles = roles;
	}
}
