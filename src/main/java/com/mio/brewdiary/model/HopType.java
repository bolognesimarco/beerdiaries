package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HopType {
	
	public HopType() {}
	
	public HopType(int id){
		this.id=id;
	}
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private double aa;
	
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

	public double getAa() {
		return aa;
	}

	public void setAa(double aa) {
		this.aa = aa;
	}

}
