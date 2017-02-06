package ua.nure.drozdyk.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.constant.Roles;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.LoginForm;
import ua.nure.drozdyk.hospital.model.Account;

/**
 * Login controller.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = -7833038974413608160L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute(Attributes.CURRENT_ACCOUNT) != null) {
			response.sendRedirect("admin/home");
		} else {
			forwardToPage("login-form.jsp", request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginForm form = createForm(LoginForm.class, request);
			Account account = getCommonService().login(form);
			request.getSession().setAttribute(Attributes.CURRENT_ACCOUNT, account);

			if (form.isRemember()) {
				response.addCookie(createCookie(account));
			}
			String location = nextController(form.getRole());
			response.sendRedirect(location);
			;
		} catch (ValidationException ex) {
			String msg = translate(request, ex.getMessage());
			request.setAttribute(Attributes.LOGIN_ERROR, msg);
			forwardToPage("login-form.jsp", request, response);
		}
	}

	/**
	 * Returns url of the next controller.
	 * 
	 * @param idRole
	 *            in web system.
	 * @return url.
	 */
	private String nextController(int idRole) {
		if (idRole == Roles.ID_ADMIN) {
			return "admin/home";
		}
		if (idRole == Roles.ID_DOCTOR) {
			return "doctor/home";
		}
		if (idRole == Roles.ID_NURSE) {
			return "nurse/home";
		}

		return null;
	}

	/**
	 * Creates cookie for account.
	 * 
	 * @param account.
	 * @return cookie.
	 */
	private Cookie createCookie(Account account) {
		String rememberToken = getCommonService().generateRememberToken(account);
		Cookie cookie = new Cookie(Attributes.COOKIE_FOR_AUTO_LOGIN, rememberToken);
		cookie.setMaxAge(Attributes.COOKIE_MAX_AGE_WEEK);
		return cookie;
	}
}
