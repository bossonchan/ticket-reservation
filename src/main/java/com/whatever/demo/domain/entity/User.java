package com.whatever.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 4043761002696035238L;

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	private String password;
	
	private String username;
	private String avatar;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<FilmComment> filmComments = new ArrayList<FilmComment>();
	
	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.avatar = "/default.png";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
