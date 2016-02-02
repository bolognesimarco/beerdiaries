package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mash {
	
	public Mash() {}
	
	public Mash(int t, int m, MashPhase p){
		this.temperature=t;
		this.minutes=m;
		this.phase=p;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="phase", nullable=false)
	private MashPhase phase;
	
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
	public MashPhase getPhase() {
		return phase;
	}
	public void setPhase(MashPhase phase) {
		this.phase = phase;
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
	

}
