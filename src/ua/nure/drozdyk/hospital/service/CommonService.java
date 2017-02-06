package ua.nure.drozdyk.hospital.service;

import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.LoginForm;
import ua.nure.drozdyk.hospital.model.Account;

/**
 * Defines common methods for work in system.
 *
 * @author E.Drozdyk
 * @version 1.0
 */
public interface CommonService extends BaseService {

	/**
	 * Logins into system.
	 * 
	 * @param form
	 *            of login.
	 * @return account object.
	 */
	Account login(LoginForm form) throws ValidationException;

	/**
	 * Finds account by id.
	 * 
	 * @param idAccount.
	 * @return account object.
	 */
	Account findAccount(Long idAccount);

	/**
	 * Generates remember-token for cookies.
	 * 
	 * @param account
	 *            object.
	 * @return remember-token.
	 */
	String generateRememberToken(Account account);

	/**
	 * Finds account by remember-token.
	 * 
	 * @param rememberToken
	 *            of account.
	 * @return account object.
	 */
	Account findAccount(String rememberToken);
}
