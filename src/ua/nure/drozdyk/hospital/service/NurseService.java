package ua.nure.drozdyk.hospital.service;

import java.util.List;

import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Procedure;

/**
 * Defines methods for nurse work in system.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface NurseService extends BaseService {

	/**
	 * Finds all patients with diagnosis.
	 * 
	 * @return list of patients.
	 */
	List<Account> findPatients();

	/**
	 * Finds all account card entities.
	 * 
	 * @param idPatient.
	 * @return account card object.
	 */
	AccountCard findAccountCard(long idPatient);

	/**
	 * Finds medical card.
	 * 
	 * @param idCard.
	 * @return card object.
	 */
	Card findCard(long idCard);

	/**
	 * Finds procedure of patient card.
	 * 
	 * @param idCard.
	 * @return procedure object.
	 */
	Procedure findProcedure(long idCard);

	/**
	 * Finds medicament of patient card.
	 * 
	 * @param idCard.
	 * @return medicament object.
	 */
	Medicament findMedicament(long idCard);

	/**
	 * Assigns done for procedure for medical card.
	 * 
	 * @param idCard
	 * @param idProcedure
	 */
	void assignProcedureDone(int idProcedure);

	/**
	 * Assigns done for medicament for medical card.
	 * 
	 * @param idCard.
	 * @param idMedicament.
	 */
	void assignMedicamentDone(int idMedicament);
}
