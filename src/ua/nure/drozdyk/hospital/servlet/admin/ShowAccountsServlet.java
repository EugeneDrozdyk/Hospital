package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.constant.Roles;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.DoctorPatient;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for showing account doctors.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/showAccounts")
public class ShowAccountsServlet extends BaseServlet {
	private static final long serialVersionUID = -7946762013724667854L;
	private static final int ID_SORT_DEFAULT = 0;
	private static final int ID_SORT_ABC = 1;
	private static final int ID_SORT_DATE = 2;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Account> accounts = null;
		int idRole = 0;
		int idSort = 0;

		// Getting role of user
		if (request.getParameter("idRole") != null) {
			idRole = Integer.parseInt(request.getParameter("idRole"));
		} else {
			idRole = (int) request.getSession().getAttribute(Attributes.ID_ROLE);
		}
		// Getting id of sorting
		if (request.getParameter("idSort") != null) {
			idSort = Integer.parseInt(request.getParameter("idSort"));
		}

		if (idRole == Roles.ID_DOCTOR) {
			if (request.getParameter("idCategory") != null) {
				int idCategory = Integer.parseInt(request.getParameter("idCategory"));
				accounts = getAdminService().findDoctors(idCategory);
				request.getSession().removeAttribute(Attributes.ID_ROLE);

			} else {
				List<Integer> count = new ArrayList<>();
				if (idSort == ID_SORT_DEFAULT) {
					accounts = getAdminService().findAccounts(Roles.ID_DOCTOR);
				}
				if (idSort == ID_SORT_ABC) {
					accounts = getAdminService().findAccountsOrderABC(Roles.ID_DOCTOR);
				}
				if (idSort == ID_SORT_DATE) {
					accounts = getAdminService().findAccountsOrderDate(Roles.ID_DOCTOR);
				}
				for (int i = 0; i < accounts.size(); i++) {
					List<DoctorPatient> patients = getAdminService().findDoctorPatient(accounts.get(i).getId());
					count.add(patients.size());
				}

				request.getSession().setAttribute(Attributes.ID_ROLE, idRole);
				request.getSession().setAttribute(Attributes.PATIENTS_COUNT, count);
			}
		}
		if (idRole == Roles.ID_NURSE) {
			if (idSort == ID_SORT_DEFAULT) {
				accounts = getAdminService().findAccounts(Roles.ID_NURSE);
			}
			if (idSort == ID_SORT_ABC) {
				accounts = getAdminService().findAccountsOrderABC(Roles.ID_NURSE);
			}
			if (idSort == ID_SORT_DATE) {
				accounts = getAdminService().findAccountsOrderDate(Roles.ID_NURSE);
			}
			request.getSession().setAttribute(Attributes.ID_ROLE, idRole);
		}
		if (idRole == Roles.ID_PATIENT) {
			accounts = getAdminService().findPatients(false);
			request.getSession().removeAttribute(Attributes.ID_ROLE);
		}

		// Removing of registration error
		if (request.getSession().getAttribute(Attributes.REGISTRATION_ERROR) != null) {
			request.getSession().removeAttribute(Attributes.REGISTRATION_ERROR);
		}
		// Removing of updating error
		if (request.getSession().getAttribute(Attributes.UPDATING_ERROR) != null) {
			request.getSession().removeAttribute(Attributes.UPDATING_ERROR);
		}

		request.getSession().setAttribute(Attributes.USERS_ACCOUNTS, accounts);
		response.sendRedirect("home");
	}
}
