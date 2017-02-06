package ua.nure.drozdyk.hospital.model;

import java.io.Serializable;

/**
 * Category entity.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class Category implements Serializable {
	private static final long serialVersionUID = -2587542733614283029L;

	private int id;
	private String name;

	public Category() {

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
