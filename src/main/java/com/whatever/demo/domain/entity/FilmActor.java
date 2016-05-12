package com.whatever.demo.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class FilmActor {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String avatar;
	private String bio;
	
	@ManyToMany(mappedBy = "actors")
	private List<FilmDescription> films;
	
	public FilmActor() {}

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<FilmDescription> getFilms() {
		return films;
	}

	public void setFilms(List<FilmDescription> films) {
		this.films = films;
	}
	
}
