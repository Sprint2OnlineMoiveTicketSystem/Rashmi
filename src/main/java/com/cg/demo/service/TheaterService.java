package com.cg.demo.service;

import java.util.List;

import com.cg.demo.model.City;
import com.cg.demo.model.Theater;

public interface TheaterService {
	public Theater saveTheater(Theater t);
	public List<Theater> getTheater();
	public Theater findOne(long ID);
	public String deleteTheater(Theater t);
	public List<Theater> getTheaterByCityId(City c);

}
