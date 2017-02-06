package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

import ua.nure.drozdyk.hospital.annotation.Column;

/**
 * AccountCard entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class AccountCard implements Serializable {
	private static final long serialVersionUID = -2894512495703426029L;

	private Long id;
	@Column("id_patient")
	private Long idPatient;
	@Column("id_card")
	private Long idCard;

	public AccountCard() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "AccountCard [id=" + id + ", idPatient=" + idPatient + ", idCard=" + idCard + "]";
	}
	
	
}
