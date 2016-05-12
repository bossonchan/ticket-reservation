package com.whatever.demo.domain;

import java.util.Date;
import java.util.List;

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
	
	@OneToOne
	@JoinColumn(name = "filmDescriptionId")
	private FilmDescription filmDescription;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_cinema", joinColumns = { 
		@JoinColumn(name = "cinemaId", nullable = false)
	}, inverseJoinColumns = { 
		@JoinColumn(name = "filmId", nullable = false) 
	})
	@JsonIgnore
	private List<Cinema> cinemas;
	
	@ManyToMany
	@JoinTable(name = "film_room", joinColumns = {
		@JoinColumn(name = "roomId", nullable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "filmId", nullable = false)
	})
	@JsonIgnore
	private List<Room> rooms;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ReservationItem> items;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<FilmComment> filmComments;

	private FilmGenres genres;
	private Date startTime;
	private Date endTime;
	
	private Float price;
	
	public Film() {}

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

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
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

	public FilmGenres getGenres() {
		return genres;
	}

	public void setGenres(FilmGenres genres) {
		this.genres = genres;
	}

}
