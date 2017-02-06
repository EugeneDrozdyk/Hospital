package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

import ua.nure.drozdyk.hospital.annotation.Column;

/**
 * DoctorPatient entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class DoctorPatient implements Serializable {
	private static final long serialVersionUID = 1672673211868503517L;

	private Long id;
	@Column("id_doctor")
	private Long idDoctor;
	@Column("id_patient")
	private Long idPatient;
	private Boolean healthy;

	public DoctorPatient() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public Boolean getHealthy() {
		return healthy;
	}

	public void setHealthy(Boolean healthy) {
		this.healthy = healthy;
	}
}
