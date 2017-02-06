package ua.nure.drozdyk.hospital.servlet.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Services;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for performing treatment doctors.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/doctor/perform")
public class PerformTreatmentServlet extends BaseServlet {
	private static final long serialVersionUID = -7946762013724667854L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idService = Integer.parseInt(request.getParameter("idService"));
		long idPatient = Long.parseLong(request.getParameter("id"));
		AccountCard accountCard = getDoctorService().findAccountCard(idPatient);
		Card card = getDoctorService().findCard(accountCard.getIdCard());
		if (idService == Services.ID_PROCEDURE) {
			Procedure procedure = getDoctorService().findProcedure(card.getId());
			if (procedure != null) {
				getDoctorService().assignProcedureDone(procedure.getId());
			}
		}
		if (idService == Services.ID_MEDICAMENT) {

			Medicament medicament = getDoctorService().findMedicament(card.getId());
			if (medicament != null) {
				getDoctorService().assignMedicamentDone(medicament.getId());
			}
		}
		if (idService == Services.ID_OPERATION) {
			Operation operation = getDoctorService().findOperation(card.getId());
			if (operation != null) {
				getDoctorService().assignOperationDone(operation.getId());
			}
		}
		
		response.sendRedirect("home");
	}
}
