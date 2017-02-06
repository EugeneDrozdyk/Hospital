package ua.nure.drozdyk.hospital.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for deactivating account.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/admin/assignDoctor")
public class AssignDoctorServlet extends BaseServlet {
	private static final long serialVersionUID = -7579823596066806927L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idDoctor = Long.parseLong(request.getParameter("doctor"));
		long idPatient = Long.parseLong(request.getParameter("currentId"));
		getAdminService().assignDoctor(idDoctor, idPatient);
		getAdminService().changePatientState(true, idPatient);
		response.sendRedirect("home");
	}
}
