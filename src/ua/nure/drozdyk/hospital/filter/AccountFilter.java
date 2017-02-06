package ua.nure.drozdyk.hospital.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.model.Account;

/**
 * Web filter that checks current account from session and defines URI access.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebFilter(filterName = "AccountFilter")
public class AccountFilter extends BaseFilter {
	private static final Logger LOGGER = Logger.getLogger(AccountFilter.class);

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Account account = (Account) request.getSession().getAttribute(Attributes.CURRENT_ACCOUNT);
		String currentUri = request.getRequestURI();

		if (account == null && isProtectedUri(currentUri)) {
			response.sendRedirect("/SummaryTask4/login");
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * Checks String URI on protecting.
	 * 
	 * @param currentUri
	 *            checking URI
	 * @return true if URI is protected or false if URI is unprotected.
	 */
	private boolean isProtectedUri(String currentUri) {
		LOGGER.debug(currentUri);
		if (currentUri.startsWith("/SummaryTask4/admin/")) {
			return true;
		}
		if (currentUri.startsWith("/SummaryTask4/doctor/")) {
			return true;
		}
		if (currentUri.startsWith("/SummaryTask4/nurse/")) {
			return true;
		}

		return false;
	}
}
