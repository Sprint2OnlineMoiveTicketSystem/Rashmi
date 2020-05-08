package com.cg.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nishant
 *
 */
@Entity
@Table(name = "city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seqgen")
	@SequenceGenerator(name="seqgen",sequenceName="seqNmae")
	private long cityId;

	@Column(nullable = false)
	private String cityName;

	private String cityPincode;

	private String cityState;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Theater> theTheater;

	public City() {
		super();
	}

	public City(String cityName, String cityPincode, String cityState, List<Theater> theTheater) {
		super();
		this.cityName = cityName;
		this.cityPincode = cityPincode;
		this.cityState = cityState;
		this.theTheater = theTheater;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(String cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public List<Theater> getTheTheater() {
		return theTheater;
	}

	public void setTheTheater(List<Theater> theTheater) {
		this.theTheater = theTheater;
	}
}