package ua.nure.drozdyk.hospital.exception;

/**
 * Validation of input dates of user.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class ValidationException extends Exception {
	private static final long serialVersionUID = -6969740053489990136L;
	
	public ValidationException(String message) {
		super(message);
	}		

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
