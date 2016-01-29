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
	private int grams;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private YeastType type;
	
	@ManyToOne
	@JoinColumn(name="format", nullable=false)
	private YeastFormat format;
	
	@Column
	private int temperature;
	
	@Column
	private int minutes;
	
	
	
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
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
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
