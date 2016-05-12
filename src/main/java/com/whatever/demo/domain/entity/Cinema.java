package com.whatever.demo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Hibernate;

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
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Film> films = new ArrayList<Film>();
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Room> rooms = new ArrayList<Room>();
	
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
}
