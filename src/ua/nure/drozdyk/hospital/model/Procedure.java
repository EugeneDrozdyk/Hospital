package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

/**
 * Procedure entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Procedure implements Serializable {
	private static final long serialVersionUID = -1397312649720532143L;
	
	private int id;
	private String name;
	
	public Procedure() {
		
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

	@Override
	public String toString() {
		return "Procedure [id=" + id + ", name=" + name + "]";
	}		
}
