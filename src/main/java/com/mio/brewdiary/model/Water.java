package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Water {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private WaterType type;
	
	@Column
	private int litres;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLitres() {
		return litres;
	}
	public void setLitres(int litres) {
		this.litres = litres;
	}
	public WaterType getType() {
		return type;
	}
	public void setType(WaterType type) {
		this.type = type;
	}

}
