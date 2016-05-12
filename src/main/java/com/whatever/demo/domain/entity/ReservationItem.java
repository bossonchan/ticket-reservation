package com.whatever.demo.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ReservationItem {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "reservationId")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name = "seatId")
	private RoomSeat seat;
	
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "filmId")
	private Film film;
	
	public ReservationItem() {}
	
	public ReservationItem(Reservation reservation, Film film, RoomSeat seat) {
		this.reservation = reservation;
		
		this.film = film;
		
		this.room = film.getRoom();
		
		this.seat = seat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public RoomSeat getSeat() {
		return seat;
	}

	public void setSeat(RoomSeat seat) {
		this.seat = seat;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
}
