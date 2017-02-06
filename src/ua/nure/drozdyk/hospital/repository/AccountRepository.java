package ua.nure.drozdyk.hospital.repository;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.ReturnType;
import ua.nure.drozdyk.hospital.annotation.sql.Delete;
import ua.nure.drozdyk.hospital.annotation.sql.Insert;
import ua.nure.drozdyk.hospital.annotation.sql.Select;
import ua.nure.drozdyk.hospital.annotation.sql.Update;
import ua.nure.drozdyk.hospital.form.RegistrationForm;
import ua.nure.drozdyk.hospital.form.UpdatingForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.DoctorPatient;

/**
 * Defines all methods for work with account table from database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface AccountRepository extends BaseRepository {

	/**
	 * Finds account by login.
	 * 
	 * @param login
	 *            of account.
	 * @return account object.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNT_BY_LOGIN)
	Account findAccount(String login);

	/**
	 * Finds account by id.
	 * 
	 * @param idAccount.
	 * @return account object.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNT_BY_ID)
	Account findAccount(long idAccount);

	/**
	 * Finds account by email.
	 * 
	 * @param email
	 *            of account.
	 * @return account object.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNT_BY_EMAIL)
	Account findAccountByEmail(String email);

	/**
	 * Finds account by id account and id role.
	 * 
	 * @param idAccount.
	 * @param idRole.
	 * @return account object.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNT_BY_ID_AND_ROLE)
	Account findAccount(long idAccount, int idRole);

	/**
	 * Finds all accounts.
	 * 
	 * @return list of accounts.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNTS)
	@ReturnType(entityClass = Account.class)
	List<Account> findAccounts();

	/**
	 * Finds all accounts by id of role in system.
	 * 
	 * @return list of accounts.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNTS_BY_ROLE)
	@ReturnType(entityClass = Account.class)
	List<Account> findAccounts(int idRole);

	/**
	 * Finds all accounts by id of role in system with sorting by ABC.
	 * 
	 * @param idRole.
	 * @return list of sorted accounts.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNTS_ORDER_BY_ABC)
	@ReturnType(entityClass = Account.class)
	List<Account> findAccountsOrderABC(int idRole);

	/**
	 * Finds all accounts by id of role in system with sorting by date of birth.
	 * 
	 * @param idRole.
	 * @return list of sorted accounts.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNTS_ORDER_BY_DATE)
	@ReturnType(entityClass = Account.class)
	List<Account> findAccountsOrderDate(int idRole);

	/**
	 * Finds all accounts of patients by their state.
	 * 
	 * @param isAssigned
	 *            state.
	 * @return list of patients.
	 */
	@Select(sql = QueryStorage.FIND_PATIENTS)
	@ReturnType(entityClass = Account.class)
	List<Account> findPatients(boolean isAssigned);
	
	/**
	 * Finds all patients with diagnosis.
	 * 
	 * @return list of patients.
	 */
	@Select(sql = QueryStorage.FIND_ALL_PATIENTS)
	@ReturnType(entityClass = Account.class)
	List<Account> findPatients();

	/**
	 * Finds all accounts of doctors by id of doctor category in system.
	 * 
	 * @param idCategory
	 *            of doctors.
	 * @return list of doctors accounts.
	 */
	@Select(sql = QueryStorage.FIND_DOCTORS_BY_CATEGORY)
	@ReturnType(entityClass = Account.class)
	List<Account> findDoctors(int idCategory);

	/**
	 * Finds last id of account.
	 * 
	 * @return last id of account.
	 */
	@Select(sql = QueryStorage.FIND_LAST_ACCOUNT)
	Account findLastAccount();

	/**
	 * Removes account by id.
	 * 
	 * @param idAccount.
	 */
	@Delete(sql = QueryStorage.REMOVE_ACCOUNT_BY_ID)
	void removeAccount(long idAccount);

	/**
	 * Removes account role by id.
	 * 
	 * @param idAccount.
	 */
	@Delete(sql = QueryStorage.REMOVE_ACCOUNT_ROLE)
	void removeAccountRole(long idAccount);

	/**
	 * Creates a new account in database.
	 * 
	 * @param account
	 *            object.
	 */
	@Insert(sql = QueryStorage.CREATE_ACCOUNT)
	void createNewAccount(RegistrationForm account, boolean isAssigned);

	/**
	 * Updates account with date of form by id of account.
	 * 
	 * @param form.
	 * @param idAccount.
	 */
	@Update(sql = QueryStorage.UPDATE_ACCOUNT)
	void updateAccount(UpdatingForm form, long idAccount);

	/**
	 * Assigns role for a new account.
	 * 
	 * @param idAccount.
	 * @param idRole.
	 */
	@Insert(sql = QueryStorage.ASSIGN_ACCOUNT_ROLE)
	void assignRole(long idAccount, int idRole);

	/**
	 * Changes activity of account by id.
	 * 
	 * @param acvite
	 *            new state of account.
	 * @param id
	 *            of account.
	 */
	@Update(sql = QueryStorage.CHANGE_ACCOUNT_ACTIVITY)
	void changeAccountActivity(boolean acvite, long idAccount);

	/**
	 * Changes patient state by account id.
	 * 
	 * @param asigned
	 *            new state of patient.
	 */
	@Update(sql = QueryStorage.CHANGE_PATIENT_STATE)
	void changePatientState(boolean asigned, long idAccount);

	/**
	 * Finds all accounts of patients by id of doctor.
	 * 
	 * @return list of patients accounts.
	 */
	@Select(sql = QueryStorage.FIND_PATIENTS_BY_DOCTOR_ID)
	@ReturnType(entityClass = Account.class)
	public List<Account> findPatients(long idDoctor, boolean healty);

	/**
	 * Assigns doctor for patients.
	 * 
	 * @param idDoctor.
	 * @param idPatient.
	 */
	@Insert(sql = QueryStorage.ASSIGN_DOCTOR)
	void assignDoctor(long idDoctor, long idPatient);

	/**
	 * Changes health of patient.
	 * 
	 * @param idPatient.
	 */
	@Update(sql = QueryStorage.CHANGE_PATIENT_HEALT)
	void changeHealth(long idPatient);

	/**
	 * Finds patients of doctor
	 * 
	 * @param idDoctor.
	 * @return count of patients.
	 */
	@Select(sql = QueryStorage.FIND_DOCTOR_PATIENT)
	@ReturnType(entityClass = DoctorPatient.class)
	List<DoctorPatient> findDoctorPatient(long idDoctor);
}
