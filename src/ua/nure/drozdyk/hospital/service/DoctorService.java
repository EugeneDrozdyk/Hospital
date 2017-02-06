package ua.nure.drozdyk.hospital.service;

import java.util.List;

import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.DiagnosisForm;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.Procedure;

/**
 * Defines methods for doctor work in system.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface DoctorService extends BaseService {

	/**
	 * Finds all accounts of patients by id of doctor.
	 * 
	 * @return list of patients accounts.
	 */
	List<Account> findPatients(long idDoctor, boolean helthy);

	/**
	 * Changes activity of account by id.
	 * 
	 * @param acvite
	 *            new state of account.
	 * @param id
	 *            of account.
	 */
	void changeAccountActivity(boolean acvite, long idAccount);

	/**
	 * Finds all possible procedures of hospital.
	 * 
	 * @return list of procedures.
	 */
	List<Procedure> findProdecures();

	/**
	 * Finds all possible medicaments of hospital.
	 * 
	 * @return list of medicaments.
	 */
	List<Medicament> findMedicaments();

	/**
	 * Finds all possible operations of hospital.
	 * 
	 * @return list of operations.
	 */
	List<Operation> findOperations();

	/**
	 * Creates medical card.
	 * 
	 * @param diagnosis
	 *            form.
	 */
	void createCard(DiagnosisForm form);

	/**
	 * Assigns medical card for patient.
	 * 
	 * @param idPatient.
	 * @param idCard.
	 */
	void assignCard(long idPatient, long idCard);

	/**
	 * Finds last medical card in table.
	 * 
	 * @return card object.
	 */
	Card findLastCard();

	/**
	 * Changes health of patient.
	 * 
	 * @param idPatient.
	 */
	void changeHealth(long idPatient);

	/**
	 * Validates diagnosis form.
	 * 
	 * @param form
	 *            for registration.
	 */
	void validate(DiagnosisForm form) throws ValidationException;

	/**
	 * Assign procedure for medical card.
	 * 
	 * @param idCard.
	 * @param idProcedure.
	 */
	void assignProcedure(long idCard, int idProcedure);

	/**
	 * Assign medicament for medical card.
	 * 
	 * @param idCard.
	 * @param idMedicament.
	 */
	void assignMedicament(long idCard, int idMedicament);

	/**
	 * Assign operation for medical card.
	 * 
	 * @param idCard.
	 * @param idOperation.
	 */
	void assignOperation(long idCard, int idOperation);	

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
	 * Finds operation of patient card.
	 * 
	 * @param idCard.
	 * @return operation object.
	 */
	Operation findOperation(long idCard);
	
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

	/**
	 * Assigns done for operation for medical card.
	 * 
	 * @param idCard.
	 * @param idOperation.
	 */
	void assignOperationDone(int idOperation);
}
