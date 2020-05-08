package com.cg.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.exception.TheaterNotFound;
import com.cg.demo.model.City;
import com.cg.demo.model.Theater;
import com.cg.demo.repository.TheaterDao;



@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	@Autowired 
	private TheaterDao theaterdao;

	@Override
	public Theater saveTheater(Theater t) {
		return theaterdao.save(t);
	}

	@Override
	public List<Theater> getTheater() {
		return theaterdao.getTheater();
	}

	@Override
	public Theater findOne(long ID) {
		return theaterdao.findOne(ID);
	}

	@Override
	public String deleteTheater(Theater t) {
		Optional<Theater> th= theaterdao.findById(t.getTheaterId());
		 if(!th.isPresent())
		 {
			 throw new TheaterNotFound("Theater not found");
		 }
		
		return theaterdao.deleteTheater(t);
		
	}

	@Override
	public List<Theater> getTheaterByCityId(City c) {
		return theaterdao.getTheaterByCityId(c);		
	}
	
	

}
