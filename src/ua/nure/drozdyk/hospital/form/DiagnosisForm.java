package ua.nure.drozdyk.hospital.form;

/**
 * Diagnosis form for holding diagnosis.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class DiagnosisForm implements BaseForm {
	
	private String diagnosis;
	
	public DiagnosisForm() {
		
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}	
}
