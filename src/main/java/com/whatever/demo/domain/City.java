package com.whatever.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String acronyms;
	private int code;
	
	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY)
	@JsonIgnore
	private Location location;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<District> districts;
	
	public City() {}
	
	public City(String name, String acronyms, int code) {
		this.name = name;
		this.acronyms = acronyms;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronyms() {
		return acronyms;
	}

	public void setAcronyms(String acronyms) {
		this.acronyms = acronyms;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
