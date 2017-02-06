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
 * Controller for showing statistic.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/statistic")
public class ShowStatisticsServlet extends BaseServlet {
	private static final long serialVersionUID = 6855886951851006420L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> counts = new ArrayList<>();
		List<Account> doctors = getAdminService().findAccounts(Roles.ID_DOCTOR);
		for (int i = 0; i < doctors.size(); i++) {
			List<DoctorPatient> patients = getAdminService().findDoctorPatient(doctors.get(i).getId());
			counts.add(patients.size());
		}
		request.getSession().setAttribute(Attributes.USERS_ACCOUNTS, doctors);
		request.getSession().setAttribute(Attributes.PATIENTS_STATISTICS, counts);

		forwardToPage("admin/statistics.jsp", request, response);
	}
}
