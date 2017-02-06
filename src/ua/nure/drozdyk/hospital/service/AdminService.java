package ua.nure.drozdyk.hospital.service;

import java.util.List;

import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.RegistrationForm;
import ua.nure.drozdyk.hospital.form.UpdatingForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.Category;
import ua.nure.drozdyk.hospital.model.DoctorPatient;

/**
 * Defines methods for administrator work in system.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface AdminService extends BaseService {

	/**
	 * Finds all accounts.
	 * 
	 * @return list of accounts.
	 */
	List<Account> findAccounts();

	/**
	 * Finds all accounts by id of role in system.
	 * 
	 * @return list of accounts.
	 */
	List<Account> findAccounts(int idRole);

	/**
	 * Finds all account by id of role in system with sorting by ABC.
	 * 
	 * @param idRole.
	 * @return list of sorted accounts.
	 */
	List<Account> findAccountsOrderABC(int idRole);

	/**
	 * Finds all accounts by id of role in system with sorting by date of birth.
	 * 
	 * @param idRole.
	 * @return list of sorted accounts.
	 */
	List<Account> findAccountsOrderDate(int idRole);

	/**
	 * Finds all accounts of patients by their state.
	 * 
	 * @param isAssigned
	 *            state.
	 * @return list of patients.
	 */
	List<Account> findPatients(boolean isAssigned);

	/**
	 * Finds all accounts of doctors by id of doctor category in system.
	 * 
	 * @param idCategory
	 *            of doctors.
	 * @return list of doctors accounts.
	 */
	List<Account> findDoctors(int idCategory);

	/**
	 * Finds all categories of doctors.
	 * 
	 * @return list of categories.
	 */
	List<Category> findCategories();

	/**
	 * Finds last id of account.
	 * 
	 * @return last id of account.
	 */
	Account findLastAccount();

	/**
	 * Removes account by id.
	 * 
	 * @param idAccount
	 *            of removing account.
	 */
	void removeAccount(long idAccount);

	/**
	 * Removes account role by id.
	 * 
	 * @param idAccount.
	 */
	void removeAccountRole(long idAccount);

	/**
	 * Crates new account.
	 * 
	 * @param account
	 *            for creating.
	 */
	void createNewAccount(RegistrationForm account, boolean isAssigned);

	/**
	 * Assigns role for a new account.
	 * 
	 * @param idAccount.
	 * @param idRole.
	 */
	void assignRole(long idAccount, int idRole);

	/**
	 * Validates registration form.
	 * 
	 * @param form
	 *            for registration.
	 */
	void validate(RegistrationForm form) throws ValidationException;

	/**
	 * Validates updating form.
	 * 
	 * @param form
	 *            for updating.
	 */
	void validate(UpdatingForm form) throws ValidationException;

	/**
	 * Changes patient state by account id.
	 * 
	 * @param asigned
	 *            new state of patient.
	 */
	void changePatientState(boolean asigned, long idAccount);

	/**
	 * Assigns doctor for patients.
	 * 
	 * @param idDoctor.
	 * @param idPatient.
	 */
	void assignDoctor(long idDoctor, long idPatient);

	/**
	 * Assigns category of doctor.
	 * 
	 * @param idDoctor.
	 * @param idCategory.
	 */
	void assignCategory(long idDoctor, int idCategory);

	/**
	 * Updates account with date of form by id of account.
	 * 
	 * @param form.
	 * @param idAccount.
	 */
	void updateAccount(UpdatingForm form, long idAccount);

	/**
	 * Finds patients of doctor
	 * 
	 * @param idDoctor.
	 * @return count of patients.
	 */
	List<DoctorPatient> findDoctorPatient(long idDoctor);;
}
