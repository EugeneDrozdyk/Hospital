package ua.nure.drozdyk.hospital.form;

/**
 * Login form for holding input dates.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class LoginForm {

	private String login;
	private String password;
	private Integer role;
	private boolean remember;

	public LoginForm() {

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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean isRemember) {
		this.remember = isRemember;
	}
}
