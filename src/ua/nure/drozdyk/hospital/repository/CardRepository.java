package ua.nure.drozdyk.hospital.repository;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.ReturnType;
import ua.nure.drozdyk.hospital.annotation.sql.Insert;
import ua.nure.drozdyk.hospital.annotation.sql.Select;
import ua.nure.drozdyk.hospital.annotation.sql.Update;
import ua.nure.drozdyk.hospital.form.DiagnosisForm;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.Procedure;

/**
 * Defines all methods for work with tables which connected with medicine card.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface CardRepository extends BaseRepository {

	/**
	 * Finds all possible procedures of hospital.
	 * 
	 * @return list of procedures.
	 */
	@Select(sql = QueryStorage.FIND_PROCEDURES)
	@ReturnType(entityClass = Procedure.class)
	List<Procedure> findProdecures();

	/**
	 * Finds all possible medicaments of hospital.
	 * 
	 * @return list of medicaments.
	 */
	@Select(sql = QueryStorage.FIND_MEDICAMENTS)
	@ReturnType(entityClass = Medicament.class)
	List<Medicament> findMedicaments();

	/**
	 * Finds all possible operations of hospital.
	 * 
	 * @return list of operations.
	 */
	@Select(sql = QueryStorage.FIND_OPERATIONS)
	@ReturnType(entityClass = Operation.class)
	List<Operation> findOperations();

	/**
	 * Creates medical card.
	 * 
	 * @param diagnosis
	 *            form.
	 */
	@Insert(sql = QueryStorage.CREATE_CARD)
	void createCard(DiagnosisForm form);

	/**
	 * Assigns medical card for patient.
	 * 
	 * @param idPatient.
	 * @param idCard.
	 */
	@Insert(sql = QueryStorage.ASSIGN_CARD_FOR_PATIENT)
	void assignCard(long idPatient, long idCard);

	/**
	 * Finds last medical card in table.
	 * 
	 * @return card object.
	 */
	@Select(sql = QueryStorage.FIND_LAST_CARD)
	Card findLastCard();

	/**
	 * Assign procedure for medical card.
	 * 
	 * @param idCard.
	 * @param idProcedure.
	 */
	@Insert(sql = QueryStorage.ASSIGN_PROCEDURE)
	void assignProcedure(long idCard, int idProcedure);

	/**
	 * Assign medicament for medical card.
	 * 
	 * @param idCard.
	 * @param idMedicament.
	 */
	@Insert(sql = QueryStorage.ASSIGN_MEDICAMENT)
	void assignMedicament(long idCard, int idMedicament);

	/**
	 * Assign operation for medical card.
	 * 
	 * @param idCard.
	 * @param idOperation.
	 */
	@Insert(sql = QueryStorage.ASSIGN_OPERATION)
	void assignOperation(long idCard, int idOperation);

	/**
	 * Finds all account card entities.
	 * 
	 * @param idPatient.
	 * @return account card object.
	 */
	@Select(sql = QueryStorage.FIND_ACCOUNT_CARDS)
	AccountCard findAccountCard(long idPatient);

	/**
	 * Finds medical card.
	 * 
	 * @param idCard.
	 * @return car object.
	 */
	@Select(sql = QueryStorage.FIND_CARDS)
	Card findCard(long idCard);

	/**
	 * Finds procedure of patient card.
	 * 
	 * @param idCard.
	 * @return procedure object.
	 */
	@Select(sql = QueryStorage.FIND_CARD_PROCEDURES)
	Procedure findProcedure(long idCard);

	/**
	 * Finds medicament of patient card.
	 * 
	 * @param idCard.
	 * @return medicament object.
	 */
	@Select(sql = QueryStorage.FIND_CARD_MEDICAMENTS)
	Medicament findMedicament(long idCard);

	/**
	 * Finds operation of patient card.
	 * 
	 * @param idCard.
	 * @return operation object.
	 */
	@Select(sql = QueryStorage.FIND_CARD_OPERATIONS)
	Operation findOperation(long idCard);

	/**
	 * Assigns done for procedure for medical card.
	 * 
	 * @param idCard.
	 * @param idProcedure.
	 */
	@Update(sql = QueryStorage.ASSIGN_PROCEDURE_DONE)
	void assignProcedureDone(int idProcedure);

	/**
	 * Assigns done for medicament for medical card.
	 * 
	 * @param idCard.
	 * @param idMedicament.
	 */
	@Update(sql = QueryStorage.ASSIGN_MEDICAMENT_DONE)
	void assignMedicamentDone(int idMedicament);

	/**
	 * Assigns done for operation for medical card.
	 * 
	 * @param idCard.
	 * @param idOperation.
	 */
	@Update(sql = QueryStorage.ASSIGN_OPERATION_DONE)
	void assignOperationDone(int idOperation);
}
