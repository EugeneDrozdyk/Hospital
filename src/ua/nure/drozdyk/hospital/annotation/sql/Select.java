package ua.nure.drozdyk.hospital.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ua.nure.drozdyk.hospital.handler.BaseResultSetHandler;

/**
 * Indicates that a method does query for selecting data from database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {

	/**
	 * @return SQL query for selecting from database.
	 */
	String sql();

	/**
	 * Returns ResultSetHandlerClass for processing dates.
	 * 
	 * @return ResultSetHandlerClass (only child of BaseResultSetHandler).
	 */
	Class<? extends BaseResultSetHandler> resultSetHandlerClass() default BaseResultSetHandler.class;
}
