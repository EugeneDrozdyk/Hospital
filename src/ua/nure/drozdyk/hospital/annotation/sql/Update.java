package ua.nure.drozdyk.hospital.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a method does query for updating dates from database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Update {

	/**
	 * @return SQL query for updating dates from database.
	 */
	String sql();
}
