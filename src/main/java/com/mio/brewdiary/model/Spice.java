package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Spice {
	
	public Spice() {}
	
	public Spice(int g, SpiceType t){
		this.grams=g;
		this.type=t;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private SpiceType type;
	
	@Column
	private int grams;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SpiceType getType() {
		return type;
	}
	public void setType(SpiceType type) {
		this.type = type;
	}
	public int getGrams() {
		return grams;
	}
	public void setGrams(int grams) {
		this.grams = grams;
	}
}
