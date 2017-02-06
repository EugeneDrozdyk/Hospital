package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;
import java.util.Date;

import ua.nure.drozdyk.hospital.annotation.Column;

/**
 * Account entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Account implements Serializable {
	private static final long serialVersionUID = -6802681834754072843L;

	private Long id;
	private String login;
	private String password;
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	@Column("middle_name")
	private String middleName;
	private String email;
	@Column("date_of_birth")
	private Date dateOfBirth;
	private Boolean active;
	private Boolean assigned;

	public Account() {

	}

	public long getId() {
		long id = this.id.longValue();
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", middleName=" + middleName + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", active=" + active + ", assigned=" + assigned + "]";
	}	
	
	
}
