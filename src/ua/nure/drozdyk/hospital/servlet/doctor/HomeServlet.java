package ua.nure.drozdyk.hospital.servlet.doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for view doctor home page.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/doctor/home")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 3697434774793676005L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Procedure> procedures = getDoctorService().findProdecures();
		request.setAttribute(Attributes.HOSPITAL_PROCEDURES, procedures);
		List<Medicament> medicaments = getDoctorService().findMedicaments();
		request.setAttribute(Attributes.HOSPITAL_MEDICAMENTS, medicaments);
		List<Operation> operations = getDoctorService().findOperations();
		request.setAttribute(Attributes.HOSPITAL_OPERATIONS, operations);

		forwardToPage("doctor/home.jsp", request, response);
	}
}
