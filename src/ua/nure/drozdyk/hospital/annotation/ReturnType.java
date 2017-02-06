package ua.nure.drozdyk.hospital.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates the return type of method.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnType {

	/**
	 * @return entity of class;
	 */
	Class<?> entityClass();
}
