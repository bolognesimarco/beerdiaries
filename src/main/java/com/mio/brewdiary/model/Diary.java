package com.mio.brewdiary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Diary {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="diary")
	private List<Cotta> cotte = new ArrayList<Cotta>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Cotta> getCotte() {
		return cotte;
	}
	public void setCotte(List<Cotta> cotte) {
		this.cotte = cotte;
	}
	
}
