package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Malt {
	
	public Malt() {}
	
	public Malt(int gr, MaltType t){
		this.grams=gr;
		this.type=t;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int grams;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private MaltType type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrams() {
		return grams;
	}
	public void setGrams(int grams) {
		this.grams = grams;
	}
	public MaltType getType() {
		return type;
	}
	public void setType(MaltType type) {
		this.type = type;
	}

}
