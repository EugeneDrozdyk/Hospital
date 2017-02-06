package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

/**
 * Medicament entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Medicament implements Serializable {
	private static final long serialVersionUID = 3478869163983142267L;
	
	private int id;
	private String name;
	
	public Medicament() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
