package com.mio.brewdiary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="style", nullable=false)
	private Style style;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="recipe")
	private List<Cotta> cotte = new ArrayList<Cotta>();
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="recipe")
	private List<Malt> malts = new ArrayList<Malt>();
	
	@OneToOne(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="mashWater", unique=true, nullable=false, updatable=false)
	private Water mashWater;
	
	@OneToOne(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="sparge", unique=true, nullable=false, updatable=false)
	private Water sparge;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="recipe")
	private List<Hop> hops = new ArrayList<Hop>();
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="recipe")
	private List<Spice> spices = new ArrayList<Spice>();
	
	@OneToOne(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="YeastId", unique=true, nullable=false, updatable=false)
	private Yeast yeast;
	
	@Column
	private int totalBoilTime;
	
	@Column
	private int expectedOG;
	
	@Column
	private int expectedFG;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="recipe")
	private List<Mash> mashSteps = new ArrayList<Mash>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public List<Cotta> getCotte() {
		return cotte;
	}
	public void setCotte(List<Cotta> cotte) {
		this.cotte = cotte;
	}
	public List<Malt> getMalts() {
		return malts;
	}
	public void setMalts(List<Malt> malts) {
		this.malts = malts;
	}
	public Water getMashWater() {
		return mashWater;
	}
	public void setMashWater(Water mashWater) {
		this.mashWater = mashWater;
	}
	public Water getSparge() {
		return sparge;
	}
	public void setSparge(Water sparge) {
		this.sparge = sparge;
	}
	public List<Hop> getHops() {
		return hops;
	}
	public void setHops(List<Hop> hops) {
		this.hops = hops;
	}
	public List<Spice> getSpices() {
		return spices;
	}
	public void setSpices(List<Spice> spices) {
		this.spices = spices;
	}
	public Yeast getYeast() {
		return yeast;
	}
	public void setYeast(Yeast yeast) {
		this.yeast = yeast;
	}
	public int getTotalBoilTime() {
		return totalBoilTime;
	}
	public void setTotalBoilTime(int totalBoilTime) {
		this.totalBoilTime = totalBoilTime;
	}
	public int getExpectedOG() {
		return expectedOG;
	}
	public void setExpectedOG(int expectedOG) {
		this.expectedOG = expectedOG;
	}
	public int getExpectedFG() {
		return expectedFG;
	}
	public void setExpectedFG(int expectedFG) {
		this.expectedFG = expectedFG;
	}
	public List<Mash> getMashSteps() {
		return mashSteps;
	}
	public void setMashSteps(List<Mash> mashSteps) {
		this.mashSteps = mashSteps;
	}
}
