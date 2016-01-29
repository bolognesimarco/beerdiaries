package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cotta {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="recipe", nullable=false)
	private Recipe recipe;
	
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
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
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
