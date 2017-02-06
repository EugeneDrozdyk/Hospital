package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

/**
 * Operation entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Operation implements Serializable {
	private static final long serialVersionUID = -3641580536325407090L;
	
	private int id;
	private String name;
	
	public Operation() {
		
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
