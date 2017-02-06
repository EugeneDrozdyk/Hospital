package ua.nure.drozdyk.hospital.servlet.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.exception.ValidationException;
import ua.nure.drozdyk.hospital.form.DiagnosisForm;
import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for prescribing of treatment for patient.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/doctor/prescribe")
public class PrescribeServlet extends BaseServlet {
	private static final long serialVersionUID = -7198380900788967448L;
	private static final Logger LOGGER = Logger.getLogger(PrescribeServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			DiagnosisForm form = createForm(DiagnosisForm.class, request);
			getDoctorService().validate(form);
			getDoctorService().createCard(form);

			long idPatient = Long.parseLong(request.getParameter("currentId"));
			long idCard = getDoctorService().findLastCard().getId();

			getDoctorService().assignCard(idPatient, idCard);
			getDoctorService().changeHealth(idPatient);

			// Services of Hospital
			int idProcedure = Integer.parseInt(request.getParameter("procedure"));
			if (idProcedure != 0) {
				getDoctorService().assignProcedure(idCard, idProcedure);
			}

			int idMedicament = Integer.parseInt(request.getParameter("medicament"));
			if (idMedicament != 0) {
				getDoctorService().assignMedicament(idCard, idMedicament);
			}

			int idOperation = Integer.parseInt(request.getParameter("operation"));
			if (idOperation != 0) {
				getDoctorService().assignOperation(idCard, idOperation);
			}
		} catch (ValidationException ex) {
			LOGGER.error(ex.getMessage());
			String msg = translate(request, ex.getMessage());
			request.getSession().setAttribute(Attributes.PRESCRIBE_ERROR, msg);
		}

		response.sendRedirect("home");
	}

}
