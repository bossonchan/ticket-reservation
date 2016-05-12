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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FilmDescription {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private int duration;
	private String country;
	private String language;
	private Date releaseDate;
	private String storyline;
	private double score;
	private String director;
	private String poster;
	private FilmGenres genres;
	
	@OneToMany(mappedBy = "filmDescription", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Film> films = new ArrayList<Film>();
	
	@ManyToMany
	@JoinTable(name = "filmDescription_actor", joinColumns = {
		@JoinColumn(name = "actorId", nullable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "filmDescriptionId", nullable = false)
	})
	private List<FilmActor> actors;
	
	public FilmDescription() {}

	public FilmDescription(String name, int duration, String country, String language, Date releaseDate,
			String storyline, double score, String director, String poster, FilmGenres genres) {
		this.name = name;
		this.duration = duration;
		this.country = country;
		this.language = language;
		this.releaseDate = releaseDate;
		this.storyline = storyline;
		this.score = score;
		this.director = director;
		this.poster = poster;
		this.genres = genres;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStoryline() {
		return storyline;
	}

	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public FilmGenres getGenres() {
		return genres;
	}

	public void setGenres(FilmGenres genres) {
		this.genres = genres;
	}

	public List<FilmActor> getActors() {
		return actors;
	}

	public void setActors(List<FilmActor> actors) {
		this.actors = actors;
	}
}

