package ua.nure.drozdyk.hospital.exception;

/**
 * Holds messages of exceptions.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public final class Messages {

	private Messages() {

	}

	public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";

	public static final String ERR_CANNOT_FOUND_CONNECTION = "Cannot found connection for current thread";

	public static final String ERR_CANNOT_PERFORM_SQL_QUERY = "Cannot perform sql query to database";

	public static final String ERR_CANNOT_PERFORM_METHOD = "Cannot perform method: ";

	public static final String ERR_ACCOUNT_LOGIN = "validate.login";

	public static final String ERR_ACCOUNT_PASSWORD = "validate.password";

	public static final String ERR_ACCOUNT_ACTIVE = "validate.active";

	public static final String ERR_CANNOT_RETURN_SUCH_TYPE = "Method with @Delete annotation should return void or int";

	public static final String ERR_CANNOT_FIND_SUCH_METHOD = "Cannot find such method: ";

	public static final String ERR_CANNOT_CONVERT_TO_TYPE = "Cannot convert to type: ";

	public static final String ERR_ACCOUNT_ACCESS_DENIED = "validate.access";

	public static final String ERR_CANNOT_PARSE_DATE = "Cannot parse such date";

	public static final String ERR_CANNOT_REGISTRATE_LOGIN = "validate.registration.login";

	public static final String ERR_CANNOT_REGISTRATE_EMAIL = "validate.registration.email";

	public static final String ERR_CANNOT_BE_EMPTY = "validate.registration.empty";

	public static final String ERR_FIELD_SIZE = "validate.registration.size";
}