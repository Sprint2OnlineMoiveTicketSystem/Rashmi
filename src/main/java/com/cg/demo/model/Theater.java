package com.cg.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "theater")
public class Theater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seqgen")
	@SequenceGenerator(name="seqgen",sequenceName="seqNmae")
	private long theaterId;

	private String theaterName;

	private String theaterArea;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private City city;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Show> show;

	public Theater() {
	}

	public Theater(String theaterName, String theaterArea, City city, List<Show> show) {
		super();
		this.theaterName = theaterName;
		this.theaterArea = theaterArea;
		this.city = city;
		this.show = show;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterArea() {
		return theaterArea;
	}

	public void setTheaterArea(String theaterArea) {
		this.theaterArea = theaterArea;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Show> getTheShow() {
		return show;
	}

	public void setTheShow(List<Show> show) {
		this.show = show;
	}

}