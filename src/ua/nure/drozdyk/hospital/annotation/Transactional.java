package ua.nure.drozdyk.hospital.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a method has access to database and defines method is
 * transactional or not.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {

	/**
	 * @return true if method is not transactional, or false if method is
	 *         transactional.
	 */
	boolean readOnly() default true;
}
