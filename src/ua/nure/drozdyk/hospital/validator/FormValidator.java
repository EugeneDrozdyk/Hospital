package ua.nure.drozdyk.hospital.validator;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.form.BaseForm;

/**
 * Validator for children of base form.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class FormValidator {
	private static final Logger LOGGER = Logger.getLogger(FormValidator.class);

	private BaseForm form;

	private static final int MIN_INPUT_LENGTH = 3;
	private static final int MAX_INPUT_LENGTH = 50;

	public FormValidator(BaseForm form) {
		this.form = form;
	}

	/**
	 * Checks input form for registration.
	 * 
	 * @return message of problem.
	 */
	public String checkForm() {
		Field[] fields = form.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.getType() != String.class) {
				continue;
			}
			if (f.getName().equals("middleName")) {
				continue;
			}
			try {
				int length = f.get(form).toString().length();
				if (!(length >= MIN_INPUT_LENGTH && length <= MAX_INPUT_LENGTH)) {
					return Messages.ERR_FIELD_SIZE;
				}
			} catch (IllegalArgumentException | IllegalAccessException ex) {
				LOGGER.error(ex.getMessage());
			}
		}

		return null;
	}
}
