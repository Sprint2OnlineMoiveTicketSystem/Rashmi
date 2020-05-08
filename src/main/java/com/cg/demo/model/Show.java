package com.cg.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nishant
 *
 */
@Entity
@Table(name = "show")
public class Show implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long showId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Theater theater;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Movie movie;

	private String showTime;

	public Show() {
		
	}

	public Show(Theater theater, Movie movie, String showTime) {
		super();
		this.theater = theater;
		this.movie = movie;
		this.showTime = showTime;
	}

	public long getShowId() {
		return showId;
	}

	public void setShowId(long showId) {
		this.showId = showId;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

}