package ua.nure.drozdyk.hospital.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * Indicates that a real name of column in database has another name other than
 * name of field in model.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	/**
	 * @return a real name of column in database.
	 */
	String value();
}
