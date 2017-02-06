package ua.nure.drozdyk.hospital.form;

/**
 * Updating form for holding input dates.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class UpdatingForm implements BaseForm {
	
	private String password;
	private String lastName;
	private String firstName;
	private String middleName;
	
	public UpdatingForm() {
		
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
}
