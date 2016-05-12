package com.whatever.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Reservation> reservations;
	
	@ManyToMany(mappedBy = "cinemas", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Film> films;
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Room> rooms;
	
	private String name;
	private String description;
	
	public Cinema() {}

	public Cinema(Location location, String name, String description) {
		this.location = location;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
