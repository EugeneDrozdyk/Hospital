package ua.nure.drozdyk.hospital.servlet.nurse;

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
import ua.nure.drozdyk.hospital.model.PatientInfo;
import ua.nure.drozdyk.hospital.model.Procedure;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for showing accounts for nurse.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/nurse/showAccounts")
public class ShowAccountServlet extends BaseServlet {
	private static final long serialVersionUID = 364591379195387663L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Account> patients = getNurseService().findPatients();
		List<PatientInfo> info = new ArrayList<>();
		List<Account> healtyPatients = new ArrayList<>();

		for (int i = 0; i < patients.size(); i++) {
			AccountCard accountCard = getNurseService().findAccountCard(patients.get(i).getId());
			if (accountCard != null) {
				Card card = getNurseService().findCard(accountCard.getIdCard());
				// Procedure for patients
				if (id == Services.ID_PROCEDURE) {
					Procedure procedure = getNurseService().findProcedure(card.getId());
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
					Medicament medicament = getNurseService().findMedicament(card.getId());
					if (medicament != null) {
						String diagnosis = card.getDiagnosis();
						String treatment = medicament.getName();
						PatientInfo patientInfo = new PatientInfo(diagnosis, treatment);
						info.add(patientInfo);
						healtyPatients.add(patients.get(i));
					}
				}
			}
		}

		request.getSession().setAttribute(Attributes.USERS_ACCOUNTS, healtyPatients);
		request.getSession().setAttribute(Attributes.PATIENT_HEALTH_INFO, info);

		request.getSession().setAttribute(Attributes.ID_SERVICE, id);
		response.sendRedirect("home");
	}
}