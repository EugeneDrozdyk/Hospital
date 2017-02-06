package ua.nure.drozdyk.hospital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;

/**
 * Logout controller.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/logout")
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 7502855770024229176L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie cookie = new Cookie(Attributes.COOKIE_FOR_AUTO_LOGIN, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		response.sendRedirect("login");
	}
}
