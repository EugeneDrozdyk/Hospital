package ua.nure.drozdyk.hospital.servlet.doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.constant.Services;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.model.AccountCard;
import ua.nure.drozdyk.hospital.model.Card;
import ua.nure.drozdyk.hospital.model.Medicament;
import ua.nure.drozdyk.hospital.model.Operation;
import ua.nure.drozdyk.hospital.model.PatientInfo;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for showing accounts for doctor.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/doctor/showAccounts")
public class ShowAccountServlet extends BaseServlet {
	private static final long serialVersionUID = -7946762013724667854L;
	private static final int ID_ILL_PATIENTS = 1;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Account doctor = (Account) request.getSession().getAttribute(Attributes.CURRENT_ACCOUNT);

		// Show patients without diagnosis
		if (id == ID_ILL_PATIENTS) {
			List<Account> illPatients = getDoctorService().findPatients(doctor.getId(), false);		
			request.getSession().setAttribute(Attributes.USERS_ACCOUNTS, illPatients);
		}

		// Show patients with diagnosis
		if (id != ID_ILL_PATIENTS) {
			List<Account> patients = getDoctorService().findPatients(doctor.getId(), true);
			List<PatientInfo> info = new ArrayList<>();
			List<Account> healtyPatients = new ArrayList<>();

			for (int i = 0; i < patients.size(); i++) {
				AccountCard accountCard = getDoctorService().findAccountCard(patients.get(i).getId());
				Card card = getDoctorService().findCard(accountCard.getIdCard());
				// Procedure for patients
				if (id == Services.ID_PROCEDURE) {
					Procedure procedure = getDoctorService().findProcedure(card.getId());
					if (procedure != null) {
						String diagnosis = card.getDiagnosis();
						String treatment = procedure.getName();
						PatientInfo patientInfo = new PatientInfo(diagnosis, treatment);
						info.add(patientInfo);
						healtyPatients.add(patients.get(i));
					}
				}
				// Medicament for patients
				if (id == Services.ID_MEDICAMENT) {
					Medicament medicament = getDoctorService().findMedicament(card.getId());
					if (medicament != null) {
						String diagnosis = card.getDiagnosis();
						String treatment = medicament.getName();
						PatientInfo patientInfo = new PatientInfo(diagnosis, treatment);
						info.add(patientInfo);
						healtyPatients.add(patients.get(i));
					}
				}

				// Operation for patients
				if (id == Services.ID_OPERATION) {
					Operation operation = getDoctorService().findOperation(card.getId());
					if (operation != null) {
						String diagnosis = card.getDiagnosis();
						String treatment = operation.getName();
						PatientInfo patientInfo = new PatientInfo(diagnosis, treatment);
						info.add(patientInfo);
						healtyPatients.add(patients.get(i));
					}

				}
			}

			request.getSession().setAttribute(Attributes.USERS_ACCOUNTS, healtyPatients);
			request.getSession().setAttribute(Attributes.PATIENT_HEALTH_INFO, info);
		}

		// Removing of prescribing error
		if (request.getSession().getAttribute(Attributes.PRESCRIBE_ERROR) != null) {
			request.getSession().removeAttribute(Attributes.PRESCRIBE_ERROR);
		}

		request.getSession().setAttribute(Attributes.ID_SERVICE, id);
		response.sendRedirect("home");
	}
}