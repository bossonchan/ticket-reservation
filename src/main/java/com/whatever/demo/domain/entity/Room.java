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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cinemaId")
	@JsonIgnore
	private Cinema cinema;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
	private List<RoomSeat> seats = new ArrayList<RoomSeat>();
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Film> films = new ArrayList<Film>();
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ReservationItem> items = new ArrayList<ReservationItem>();
	
	private String name;
	private String description;
	
	public Room() {}
	
	public Room(Cinema cinema, String name, String description) {
		this.name = name;
		this.description = description;
		this.cinema = cinema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<RoomSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<RoomSeat> seats) {
		this.seats = seats;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
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
