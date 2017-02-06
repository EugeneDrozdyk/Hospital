package ua.nure.drozdyk.hospital.service.impl;

import java.util.UUID;

import ua.nure.drozdyk.hospital.annotation.Transactional;
import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.LoginForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.repository.AccountRepository;
import ua.nure.drozdyk.hospital.service.CommonService;

/**
 * Implementation of CommonService interface.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
class CommonServiceImpl implements CommonService {

	private final AccountRepository accountRepository;

	CommonServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public Account login(LoginForm form) throws ValidationException {
		Account account = accountRepository.findAccount(form.getLogin());
		if (account == null) {
			throw new ValidationException(Messages.ERR_ACCOUNT_LOGIN);
		}
		if (!account.getPassword().equals(form.getPassword())) {
			throw new ValidationException(Messages.ERR_ACCOUNT_PASSWORD);
		}
		if (!account.isActive()) {
			throw new ValidationException(Messages.ERR_ACCOUNT_ACTIVE);
		}

		long idAccount = account.getId();
		int idRole = form.getRole();
		account = accountRepository.findAccount(idAccount, idRole);
		if (account == null) {
			throw new ValidationException(Messages.ERR_ACCOUNT_ACCESS_DENIED);
		}

		return account;
	}

	@Override
	@Transactional
	public Account findAccount(Long id) {
		return accountRepository.findAccount(id);
	}

	@Override
	public String generateRememberToken(Account account) {
		return UUID.randomUUID().toString();
	}

	@Override
	public Account findAccount(String rememberMeToken) {
		if (rememberMeToken == null || rememberMeToken.trim().length() == 0) {
			return null;
		} else {
			return new Account();
		}
	}
}
