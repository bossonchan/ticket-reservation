package com.whatever.demo.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ownerId")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "cinemaId")
	private Cinema cinema;
	
	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	private List<ReservationItem> items = new ArrayList<ReservationItem>();
	
	private Date createTime;
	private String contactPhoneNumber;
	private ReservationStatus status;
	
	public Reservation() {}
	
	public Reservation(User owner, Cinema cinema, String contactPhoneNumber) {
		this.owner = owner;
		
		this.cinema = cinema;
		
		this.contactPhoneNumber = contactPhoneNumber;
		this.createTime = new Date();
		this.status = ReservationStatus.ACTIVE;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<ReservationItem> getItems() {
		return items;
	}

	public void setItems(List<ReservationItem> items) {
		this.items = items;
	}
	
}
