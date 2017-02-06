package ua.nure.drozdyk.hospital.service.impl;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.Transactional;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.DiagnosisForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.repository.AccountRepository;
import ua.nure.drozdyk.hospital.repository.CardRepository;
import ua.nure.drozdyk.hospital.service.DoctorService;
import ua.nure.drozdyk.hospital.validator.FormValidator;

/**
 * Implementation of DoctorService interface.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
class DoctorServiceImpl implements DoctorService {

	private final AccountRepository accountRepository;
	private final CardRepository cardRepository;

	DoctorServiceImpl(AccountRepository accountRepository, CardRepository cardRepository) {
		this.accountRepository = accountRepository;
		this.cardRepository = cardRepository;
	}

	@Override
	@Transactional
	public List<Account> findPatients(long idDoctor, boolean helthy) {
		return accountRepository.findPatients(idDoctor, helthy);
	}

	@Override
	@Transactional(readOnly = false)
	public void changeAccountActivity(boolean acvite, long idAccount) {
		accountRepository.changeAccountActivity(acvite, idAccount);
	}

	@Override
	@Transactional
	public List<Procedure> findProdecures() {
		return cardRepository.findProdecures();
	}

	@Override
	@Transactional
	public List<Medicament> findMedicaments() {
		return cardRepository.findMedicaments();
	}

	@Override
	@Transactional
	public List<Operation> findOperations() {
		return cardRepository.findOperations();
	}

	@Override
	@Transactional(readOnly = false)
	public void createCard(DiagnosisForm form) {
		cardRepository.createCard(form);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignCard(long idPatient, long idCard) {
		cardRepository.assignCard(idPatient, idCard);
	}

	@Override
	@Transactional
	public Card findLastCard() {
		return cardRepository.findLastCard();
	}

	@Override
	@Transactional(readOnly = false)
	public void changeHealth(long idPatient) {
		accountRepository.changeHealth(idPatient);
	}

	@Override
	public void validate(DiagnosisForm form) throws ValidationException {
		FormValidator validator = new FormValidator(form);
		String msg = validator.checkForm();
		if (msg != null) {
			throw new ValidationException(msg);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void assignProcedure(long idCard, int idProcedure) {
		cardRepository.assignProcedure(idCard, idProcedure);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignMedicament(long idCard, int idMedicament) {
		cardRepository.assignMedicament(idCard, idMedicament);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignOperation(long idCard, int idOperation) {
		cardRepository.assignOperation(idCard, idOperation);
	}

	@Override
	@Transactional
	public AccountCard findAccountCard(long idPatient) {
		return cardRepository.findAccountCard(idPatient);
	}

	@Override
	@Transactional
	public Card findCard(long idCard) {
		return cardRepository.findCard(idCard);
	}

	@Override
	@Transactional
	public Procedure findProcedure(long idCard) {
		return cardRepository.findProcedure(idCard);
	}

	@Override
	@Transactional
	public Medicament findMedicament(long idCard) {
		return cardRepository.findMedicament(idCard);
	}

	@Override
	@Transactional
	public Operation findOperation(long idCard) {
		return cardRepository.findOperation(idCard);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignProcedureDone(int idProcedure) {
		cardRepository.assignProcedureDone(idProcedure);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignMedicamentDone(int idMedicament) {
		cardRepository.assignMedicamentDone(idMedicament);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignOperationDone(int idOperation) {
		cardRepository.assignOperationDone(idOperation);
	}
}
