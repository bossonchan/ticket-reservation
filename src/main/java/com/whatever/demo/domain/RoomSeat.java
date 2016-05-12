package com.whatever.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RoomSeat {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;
	
	@OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ReservationItem> items;
	
	private int rowNumber;
	private int colNumber;
	
	public RoomSeat() {}

}
