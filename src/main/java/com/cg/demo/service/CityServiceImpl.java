package com.cg.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.exception.CityNotFound;
import com.cg.demo.model.City;
import com.cg.demo.repository.CityDao;

@Service
@Transactional
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao ;
	
	@Override
	public City addCity(City city) {
		return cityDao.save(city) ;
	}

	@Override
	public List<City> getCity() {
		return cityDao.getCity() ;
	}

	@Override
	public String deleteCity(City city) {
		Optional<City> c = cityDao.findById(city.getCityId()) ;
		if(!c.isPresent()) {
			throw new CityNotFound("City Not Found!") ;
		}
		return cityDao.deleteCity(city) ;
	}

	@Override
	public City findOne(long Id) {
		return cityDao.findOne(Id) ;
	}

}