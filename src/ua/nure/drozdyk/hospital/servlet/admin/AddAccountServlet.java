package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.constant.Roles;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.RegistrationForm;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for adding a new account.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/addAccount")
public class AddAccountServlet extends BaseServlet {
	private static final long serialVersionUID = -7946762013724667854L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			RegistrationForm form = createForm(RegistrationForm.class, request);
			getAdminService().validate(form);
			int idRole = Integer.parseInt(request.getParameter("role"));
			boolean isAssigned = true;
			if (idRole == Roles.ID_PATIENT) {
				// All new patients don't have assignment
				isAssigned = false;
			}
			getAdminService().createNewAccount(form, isAssigned);
			long idAccount = getAdminService().findLastAccount().getId();
			getAdminService().assignRole(idAccount, idRole);
			if (idRole == Roles.ID_DOCTOR) {
				int idCategory = Integer.parseInt(request.getParameter("category"));
				request.getSession().setAttribute(Attributes.ID_CATEGORY, idCategory);
			}
		} catch (ValidationException ex) {
			String msg = translate(request, ex.getMessage());
			request.getSession().setAttribute(Attributes.REGISTRATION_ERROR, msg);
		}
		
		response.sendRedirect("home");
	}
}
