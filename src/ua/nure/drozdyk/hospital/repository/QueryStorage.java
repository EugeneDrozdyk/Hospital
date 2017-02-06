package ua.nure.drozdyk.hospital.repository;

/**
 * Holds SQL queries of application.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
final class QueryStorage {

	private QueryStorage() {

	}

	/* Queries for account repository */

	static final String FIND_ACCOUNT_BY_LOGIN = "SELECT * FROM account WHERE login=?";

	static final String FIND_ACCOUNT_BY_EMAIL = "SELECT * FROM account WHERE email=?";

	static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM account WHERE id=?";

	static final String FIND_ACCOUNT_BY_ID_AND_ROLE = "SELECT account.* FROM account, role, account_role WHERE account_role.id_account = account.id AND account_role.id_role = role.id AND account.id=? AND account_role.id_role=?";

	static final String FIND_ACCOUNTS = "SELECT * FROM account";

	static final String FIND_ACCOUNTS_BY_ROLE = "SELECT account.* FROM account, role, account_role WHERE account_role.id_account = account.id AND account_role.id_role = role.id AND account_role.id_role=?";

	static final String FIND_ACCOUNTS_ORDER_BY_ABC = "SELECT account.* FROM account, role, account_role WHERE account_role.id_account = account.id AND account_role.id_role = role.id AND account_role.id_role=? ORDER BY last_name";

	static final String FIND_ACCOUNTS_ORDER_BY_DATE = "SELECT account.* FROM account, role, account_role WHERE account_role.id_account = account.id AND account_role.id_role = role.id AND account_role.id_role=? ORDER BY date_of_birth";

	static final String FIND_PATIENTS = "SELECT account.* FROM account, role, account_role WHERE account_role.id_account = account.id AND account_role.id_role = role.id AND account_role.id_role = 4 AND account.assigned = ?";

	static final String FIND_DOCTORS_BY_CATEGORY = "SELECT account.* FROM account, category, account_category WHERE account_category.id_account = account.id AND account_category.id_category = category.id AND account_category.id_category=?";

	static final String FIND_LAST_ACCOUNT = "SELECT * FROM account ORDER BY id DESC LIMIT 1";

	static final String REMOVE_ACCOUNT_BY_ID = "DELETE FROM account WHERE id=?";

	static final String REMOVE_ACCOUNT_ROLE = "DELETE FROM account_role WHERE id_account=?";

	static final String CREATE_ACCOUNT = "INSERT INTO account"
			+ "(login, password, first_name, last_name, middle_name, email, date_of_birth, assigned) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?)";

	static final String UPDATE_ACCOUNT = "UPDATE account SET password=?, first_name=?, last_name=?, middle_name=? WHERE id=?";

	static final String ASSIGN_ACCOUNT_ROLE = "INSERT INTO account_role(id_account, id_role) values(?, ?)";

	static final String CHANGE_ACCOUNT_ACTIVITY = "UPDATE account SET active=? WHERE id=?";

	static final String CHANGE_PATIENT_STATE = "UPDATE account SET assigned=? WHERE id=?";

	static final String FIND_PATIENTS_BY_DOCTOR_ID = "SELECT account.* FROM account INNER JOIN doctor_patient ON account.id = doctor_patient.id_patient WHERE doctor_patient.id_doctor=? AND doctor_patient.healthy = ?";

	/* Queries for category repository */

	static final String FIND_CATEGORIES = "SELECT * FROM category";

	static final String ASSIGN_DOCTOR_CATEGORY = "INSERT INTO account_category(id_account, id_category) VALUES(?, ?)";

	/* Query for card repository */

	static final String ASSIGN_DOCTOR = "INSERT INTO doctor_patient(id_doctor, id_patient) values(?, ?)";

	static final String FIND_PROCEDURES = "SELECT * FROM `procedure`";

	static final String FIND_MEDICAMENTS = "SELECT * FROM medicament";

	static final String FIND_OPERATIONS = "SELECT * FROM operation";

	static final String CREATE_CARD = "INSERT INTO card (diagnosis) VALUES(?)";

	static final String FIND_LAST_CARD = "SELECT * FROM card ORDER BY id DESC LIMIT 1";

	static final String ASSIGN_CARD_FOR_PATIENT = "INSERT INTO account_card(id_patient, id_card) VALUES(?, ?)";

	static final String CHANGE_PATIENT_HEALT = "UPDATE doctor_patient SET healthy = true WHERE id_patient = ?";

	static final String ASSIGN_PROCEDURE = "INSERT INTO card_procedure(id_card, id_procedure) VALUES(?,?)";

	static final String ASSIGN_MEDICAMENT = "INSERT INTO card_medicament(id_card, id_medicament) VALUES(?,?)";

	static final String ASSIGN_OPERATION = "INSERT INTO card_operation(id_card, id_operation) VALUES(?,?)";

	static final String FIND_ACCOUNT_CARDS = "SELECT * FROM account_card WHERE id_patient = ?";

	static final String FIND_CARDS = "SELECT * FROM card WHERE id=?";

	static final String FIND_CARD_PROCEDURES = "SELECT `procedure`.* FROM `procedure`, card_procedure WHERE procedure.id = card_procedure.id_procedure AND card_procedure.id_card = ? AND card_procedure.done = false";

	static final String FIND_CARD_MEDICAMENTS = "SELECT `medicament`.* FROM `medicament`, card_medicament WHERE medicament.id = card_medicament.id_medicament AND card_medicament.id_card = ? AND card_medicament.done = false";

	static final String FIND_CARD_OPERATIONS = "SELECT `operation`.* FROM `operation`, card_operation WHERE operation.id = card_operation.id_operation AND card_operation.id_card = ? AND card_operation.done = false";

	static final String ASSIGN_PROCEDURE_DONE = "UPDATE card_procedure SET done = true WHERE id_procedure=?";

	static final String ASSIGN_MEDICAMENT_DONE = "UPDATE card_medicament SET done = true WHERE id_medicament=?";

	static final String ASSIGN_OPERATION_DONE = "UPDATE card_operation SET done = true WHERE id_operation=?";

	static final String FIND_DOCTOR_PATIENT = "SELECT * FROM `doctor_patient` WHERE id_doctor = ?";
	
	static final String FIND_ALL_PATIENTS = "SELECT account.* FROM account INNER JOIN doctor_patient ON account.id = doctor_patient.id_patient AND doctor_patient.healthy = true";	
}
