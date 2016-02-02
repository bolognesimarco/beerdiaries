package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Yeast {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private double grams;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private YeastType type;
	
	@ManyToOne
	@JoinColumn(name="format", nullable=false)
	private YeastFormat format;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrams() {
		return grams;
	}
	public void setGrams(double grams) {
		this.grams = grams;
	}
	public YeastType getType() {
		return type;
	}
	public void setType(YeastType type) {
		this.type = type;
	}
	public YeastFormat getFormat() {
		return format;
	}
	public void setFormat(YeastFormat format) {
		this.format = format;
	}

}
