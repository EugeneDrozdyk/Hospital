package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.constant.Roles;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.Category;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for view admin home page.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/home")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 3697434774793676005L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Categories of doctors for registration-form
		List<Category> categories = getAdminService().findCategories();
		request.setAttribute(Attributes.DOCTOR_CATEGORIES, categories);

		// All doctors for assignment
		List<Account> doctors = getAdminService().findAccounts(Roles.ID_DOCTOR);
		request.setAttribute(Attributes.ALL_DOCTORS, doctors);

		// Assigning of a category for new doctor
		if (request.getSession().getAttribute(Attributes.ID_CATEGORY) != null) {
			int idCategory = (int) request.getSession().getAttribute(Attributes.ID_CATEGORY);
			long idDoctor = getAdminService().findLastAccount().getId();
			getAdminService().assignCategory(idDoctor, idCategory);
			request.getSession().removeAttribute(Attributes.ID_CATEGORY);
		}
		
		forwardToPage("admin/home.jsp", request, response);
	}
}
