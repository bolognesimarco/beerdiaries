package com.mio.brewdiary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brewer {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String nickname;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy="brewer")
	private List<Cotta> cotte = new ArrayList<Cotta>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Cotta> getCotte() {
		return cotte;
	}

	public void setCotte(List<Cotta> cotte) {
		this.cotte = cotte;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
