package com.mio.brewdiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Malt {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int grams;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private MaltType type;
	
	@ManyToOne
	@JoinColumn(name="recipe", nullable=false)
	private Recipe recipe;
	
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
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
