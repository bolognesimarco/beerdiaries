package com.mio.brewdiary.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeListItem {
	private int id;
	private String name;
	private int expectedOG;
	private int expectedFG;
	private String yeastType;
	private List<String> maltTypes = new ArrayList<String>();
	private List<String> hopTypes = new ArrayList<String>();
	private List<String> spiceTypes = new ArrayList<String>();
	
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
	public List<String> getMaltTypes() {
		return maltTypes;
	}
	public void setMaltTypes(List<String> maltTypes) {
		this.maltTypes = maltTypes;
	}
	public List<String> getHopTypes() {
		return hopTypes;
	}
	public void setHopTypes(List<String> hopTypes) {
		this.hopTypes = hopTypes;
	}
	public List<String> getSpiceTypes() {
		return spiceTypes;
	}
	public void setSpiceTypes(List<String> spiceTypes) {
		this.spiceTypes = spiceTypes;
	}
	public String getYeastType() {
		return yeastType;
	}
	public void setYeastType(String yeastType) {
		this.yeastType = yeastType;
	}
	
	
}
