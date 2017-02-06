package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.UpdatingForm;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for editing account.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/editAccount")
public class EditAccountServlet extends BaseServlet {
	private static final long serialVersionUID = 6855886951851006420L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			long idAccount = Long.parseLong(request.getParameter("currentId"));
			UpdatingForm form = createForm(UpdatingForm.class, request);
			getAdminService().validate(form);
			getAdminService().updateAccount(form, idAccount);
		} catch (ValidationException ex) {
			String msg = translate(request, ex.getMessage());
			request.getSession().setAttribute(Attributes.UPDATING_ERROR, msg);
		}

		response.sendRedirect("home");
	}
}
