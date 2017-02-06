package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

/**
 * Card entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Card implements Serializable {
	private static final long serialVersionUID = 4612946460633549233L;

	private Long id;
	private String diagnosis;

	public Card() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", diagnosis=" + diagnosis + "]";
	}	
}
