package ua.nure.drozdyk.hospital.exception;

/**
 * Converter for exception into runtime.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 8332609551245332240L;

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
