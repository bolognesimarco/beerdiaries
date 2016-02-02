package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Style {
	
	public Style() {}
	
	public Style(int id){
		this.id=id;
	}
	
	@Id
	private int id;
	
	@Column
	private String name;
	
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
