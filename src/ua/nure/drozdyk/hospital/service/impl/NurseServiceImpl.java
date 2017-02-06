package ua.nure.drozdyk.hospital.service.impl;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.Transactional;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.repository.AccountRepository;
import ua.nure.drozdyk.hospital.repository.CardRepository;
import ua.nure.drozdyk.hospital.service.NurseService;

/**
 * Implementation of NurseService interface.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
class NurseServiceImpl implements NurseService {

	private final AccountRepository accountRepository;
	private final CardRepository cardRepository;

	NurseServiceImpl(AccountRepository accountRepository, CardRepository cardRepository) {
		this.accountRepository = accountRepository;
		this.cardRepository = cardRepository;
	}

	@Override
	@Transactional
	public List<Account> findPatients() {
		return accountRepository.findPatients();
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
	@Transactional(readOnly = false)
	public void assignProcedureDone(int idProcedure) {
		cardRepository.assignProcedureDone(idProcedure);
	}

	@Override
	@Transactional(readOnly = false)
	public void assignMedicamentDone(int idMedicament) {
		cardRepository.assignMedicamentDone(idMedicament);
	}
}
