package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hop {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private HopType type;
	
	@Column
	private int grams;
	
	@ManyToOne
	@JoinColumn(name="format", nullable=false)
	private HopFormat format;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HopType getType() {
		return type;
	}
	public void setType(HopType type) {
		this.type = type;
	}
	public int getGrams() {
		return grams;
	}
	public void setGrams(int grams) {
		this.grams = grams;
	}
	public HopFormat getFormat() {
		return format;
	}
	public void setFormat(HopFormat format) {
		this.format = format;
	}
}
