package com.whatever.demo.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FilmComment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ownerId")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "filmId")
	private Film film;
	
	private String content;
	private Date createTime;
	private float score;

}
