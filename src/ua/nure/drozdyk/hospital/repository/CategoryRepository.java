package ua.nure.drozdyk.hospital.repository;

import java.util.List;

import ua.nure.drozdyk.hospital.annotation.ReturnType;
import ua.nure.drozdyk.hospital.annotation.sql.Insert;
import ua.nure.drozdyk.hospital.annotation.sql.Select;
import ua.nure.drozdyk.hospital.model.Category;

/**
 * Defines all methods for work with category table from database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public interface CategoryRepository extends BaseRepository {

	/**
	 * Finds all categories of doctors.
	 * 
	 * @return list of categories.
	 */
	@Select(sql = QueryStorage.FIND_CATEGORIES)
	@ReturnType(entityClass = Category.class)
	List<Category> findAllCategories();

	/**
	 * Assigns category of doctor.
	 * 
	 * @param idDoctor.
	 * @param idCategory.
	 */
	@Insert(sql = QueryStorage.ASSIGN_DOCTOR_CATEGORY)
	void assignCategory(long idDoctor, int idCategory);

	/**
	 * Assigns doctor for patients.
	 * 
	 * @param idDoctor.
	 * @param idPatient.
	 */
	@Insert(sql = QueryStorage.ASSIGN_DOCTOR)
	void assignDoctor(long idDoctor, long idPatient);
}
