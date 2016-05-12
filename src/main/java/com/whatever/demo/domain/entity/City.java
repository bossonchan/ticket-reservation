package com.whatever.demo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private Long code;
	
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Location> locations = new ArrayList<Location>();

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<District> districts = new ArrayList<District>();
	
	public City() {}
	
	public City(String name, String acronyms, Long code) {
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

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	
}
