package ua.nure.drozdyk.hospital.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.service.AdminService;
import ua.nure.drozdyk.hospital.service.CommonService;
import ua.nure.drozdyk.hospital.service.DoctorService;
import ua.nure.drozdyk.hospital.service.NurseService;
import ua.nure.drozdyk.hospital.service.impl.ServiceManager;

/**
 * Base application controller.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 333292158155108652L;
	private static final Logger LOGGER = Logger.getLogger(BaseServlet.class);

	private ServiceManager serviceManager;

	@Override
	public final void init() throws ServletException {
		serviceManager = ServiceManager.getInstance(getServletContext());
	}

	@Override
	public final void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public CommonService getCommonService() {
		return serviceManager.getCommonService();
	}

	public AdminService getAdminService() {
		return serviceManager.getAdminService();
	}

	public DoctorService getDoctorService() {
		return serviceManager.getDoctorService();
	}
	
	public NurseService getNurseService() {
		return serviceManager.getNurseService();
	}

	protected void forwardToPage(String page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("currentPage", page);
		request.getRequestDispatcher("/WEB-INF/view/page-template.jsp").forward(request, response);
	}

	/**
	 * Creates form, from input dates.
	 * 
	 * @param formClass.
	 * @param request.
	 * @return form object.
	 */
	protected <T> T createForm(Class<T> formClass, HttpServletRequest request) throws ValidationException {
		try {
			T form = formClass.newInstance();
			Field[] fields = formClass.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				String value = request.getParameter(f.getName());
				Object convertedValue = convert(f.getType(), value);
				f.set(form, convertedValue);
			}
			return form;
		} catch (InstantiationException | IllegalAccessException | SecurityException ex) {
			throw new ValidationException(Messages.ERR_CANNOT_BE_EMPTY);
		}
	}

	/**
	 * Converts parameters of form.
	 * 
	 * @param type
	 *            target.
	 * @param value
	 *            of parameter.
	 * @return converted value.
	 */
	private Object convert(Class<?> type, String value) throws ValidationException {
		if (type == String.class) {
			return value;
		}
		if (type == Integer.class) {
			return Integer.parseInt(value);
		}
		if (type == Boolean.TYPE) {
			return value != null;
		}
		if (type == Date.class) {
			try {
				java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
				return new Date(utilDate.getTime());
			} catch (ParseException ex) {
				LOGGER.error(Messages.ERR_CANNOT_PARSE_DATE, ex);
			}
		}

		throw new ValidationException(Messages.ERR_CANNOT_BE_EMPTY);
	}

	/**
	 * Translates message subject.
	 * 
	 * @param request.
	 * @param message.
	 * @return translated message.
	 */
	protected String translate(HttpServletRequest request, String message) {
		Locale locale = request.getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("translation", locale);
		return bundle.getString(message);
	}
}
