package com.whatever.demo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy = "reservation")
	private List<ReservationItem> items;
	
	private Date createTime;
	private String contactPhoneNumber;
	
	public Reservation() {}
	
	public Reservation(User owner, String contactPhoneNumber) {
		this.owner = owner;
		this.contactPhoneNumber = contactPhoneNumber;
		this.createTime = new Date();
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
