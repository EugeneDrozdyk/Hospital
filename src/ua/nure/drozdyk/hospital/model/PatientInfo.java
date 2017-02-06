package ua.nure.drozdyk.hospital.model;

/**
 * Info about patient.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class PatientInfo {
	
	private String diagnosis;
	private String treatment;
	
	public PatientInfo(String diagnosis, String treatment) {
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}	
}
