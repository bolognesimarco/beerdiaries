package com.mio.brewdiary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mash {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="phase", nullable=false)
	private MashPhase phase;
	
	@ManyToOne
	@JoinColumn(name="recipe", nullable=false)
	private Recipe recipe;
	
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
	

}
