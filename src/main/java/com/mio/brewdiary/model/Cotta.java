package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cotta {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int og;
	
	@Column
	private int fg;
	
	@Column
	private String immagine;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOg() {
		return og;
	}
	public void setOg(int og) {
		this.og = og;
	}
	public int getFg() {
		return fg;
	}
	public void setFg(int fg) {
		this.fg = fg;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
}
