package ua.nure.drozdyk.hospital.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a method does query for inserting data to database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Insert {

	/**
	 * @return SQL query for inserting to database.
	 */
	String sql();
}
