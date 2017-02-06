package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for deleting account.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/deleteAccount")
public class DeleteAccountServlet extends BaseServlet {
	private static final long serialVersionUID = -4687457305330908366L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		getAdminService().removeAccount(id);
		getAdminService().removeAccountRole(id);
		response.sendRedirect("home");
	}
}
