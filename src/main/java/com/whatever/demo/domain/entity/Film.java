package com.whatever.demo.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Film {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "filmDescriptionId")
	private FilmDescription filmDescription;
	
	@ManyToOne
	@JoinColumn(name = "cinemaId")
	private Cinema cinema;
	
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ReservationItem> items = new ArrayList<ReservationItem>();
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<FilmComment> filmComments = new ArrayList<FilmComment>();

	private Date startTime;
	private Date endTime;
	
	private Float price;
	
	public Film() {}
	
	public Film(FilmDescription filmDescription, Cinema cinema, Room room, Date startTime, float price) {
		this.filmDescription = filmDescription;
		this.cinema = cinema;
		this.room = room;
		
		this.startTime = startTime;
		this.endTime = new Date(startTime.getTime() + filmDescription.getDuration() * 60 * 1000);
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmDescription getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(FilmDescription filmDescription) {
		this.filmDescription = filmDescription;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<ReservationItem> getItems() {
		return items;
	}

	public void setItems(List<ReservationItem> items) {
		this.items = items;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<FilmComment> getFilmComments() {
		return filmComments;
	}

	public void setFilmComments(List<FilmComment> filmComments) {
		this.filmComments = filmComments;
	}

}
