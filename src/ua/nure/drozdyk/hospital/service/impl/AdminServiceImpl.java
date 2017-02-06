package ua.nure.drozdyk.hospital.service.impl;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.Transactional;
import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.RegistrationForm;
import ua.nure.drozdyk.hospital.form.UpdatingForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.Category;
import ua.nure.drozdyk.hospital.model.DoctorPatient;
import ua.nure.drozdyk.hospital.repository.AccountRepository;
import ua.nure.drozdyk.hospital.repository.CategoryRepository;
import ua.nure.drozdyk.hospital.service.AdminService;
import ua.nure.drozdyk.hospital.validator.FormValidator;

/**
 * Implementation of AdminService interface.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
class AdminServiceImpl implements AdminService {

	private final AccountRepository accountRepository;
	private final CategoryRepository categoryRepository;

	AdminServiceImpl(AccountRepository accountRepository, CategoryRepository categoryRepository) {
		this.accountRepository = accountRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	@Transactional
	public List<Account> findAccounts() {
		return accountRepository.findAccounts();
	}

	@Override
	@Transactional
	public List<Account> findAccounts(int idRole) {
		return accountRepository.findAccounts(idRole);
	}

	@Override
	@Transactional
	public List<Account> findAccountsOrderABC(int idRole) {
		return accountRepository.findAccountsOrderABC(idRole);
	}

	@Override
	@Transactional
	public List<Account> findAccountsOrderDate(int idRole) {
		return accountRepository.findAccountsOrderDate(idRole);
	}

	@Override
	@Transactional
	public List<Account> findPatients(boolean isAssigned) {
		return accountRepository.findPatients(isAssigned);
	}

	@Override
	@Transactional
	public List<Account> findDoctors(int idCategory) {
		return accountRepository.findDoctors(idCategory);
	}

	@Override
	@Transactional
	public List<Category> findCategories() {
		return categoryRepository.findAllCategories();
	}

	@Override
	@Transactional
	public Account findLastAccount() {
		return accountRepository.findLastAccount();
	}

	@Override
	@Transactional(readOnly = false)
	public void removeAccount(long idAccount) {
		accountRepository.removeAccount(idAccount);
	}

	@Override
	@Transactional(readOnly = false)
	public void removeAccountRole(long idAccount) {
		accountRepository.removeAccountRole(idAccount);
	}

	@Override
	@Transactional(readOnly = false)
	public void createNewAccount(RegistrationForm account, boolean isAssigned) {
		accountRepository.createNewAccount(account, isAssigned);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateAccount(UpdatingForm form, long idAccount) {
		accountRepository.updateAccount(form, idAccount);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignRole(long idAccount, int idRole) {
		accountRepository.assignRole(idAccount, idRole);
	}

	@Override
	@Transactional(readOnly = false)
	public void changePatientState(boolean asigned, long idAccount) {
		accountRepository.changePatientState(asigned, idAccount);
	}

	@Override
	@Transactional
	public void validate(RegistrationForm form) throws ValidationException {
		FormValidator validator = new FormValidator(form);
		String msg = validator.checkForm();
		if (msg != null) {
			throw new ValidationException(msg);
		}

		Account account = accountRepository.findAccount(form.getLogin());
		if (account != null) {
			throw new ValidationException(Messages.ERR_CANNOT_REGISTRATE_LOGIN);
		}
		account = accountRepository.findAccountByEmail(form.getEmail());
		if (account != null) {
			throw new ValidationException(Messages.ERR_CANNOT_REGISTRATE_EMAIL);
		}
	}

	@Override
	public void validate(UpdatingForm form) throws ValidationException {
		FormValidator validator = new FormValidator(form);
		String msg = validator.checkForm();
		if (msg != null) {
			throw new ValidationException(msg);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void assignDoctor(long idDoctor, long idPatient) {
		accountRepository.assignDoctor(idDoctor, idPatient);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignCategory(long idDoctor, int idCategory) {
		categoryRepository.assignCategory(idDoctor, idCategory);
	}

	@Override
	@Transactional
	public List<DoctorPatient> findDoctorPatient(long idDoctor) {
		return accountRepository.findDoctorPatient(idDoctor);
	}
}
