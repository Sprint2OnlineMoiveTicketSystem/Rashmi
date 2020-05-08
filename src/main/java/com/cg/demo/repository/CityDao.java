package com.cg.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.demo.model.City;

@Repository
public class CityDao {


@Autowired
private CityRepository cityRepository ;

public City addCity(City city) {
	return cityRepository.save(city) ;
}

public List<City> getCity() {
	return cityRepository.findAll() ;
}

public String deleteCity(City city) {
	cityRepository.deleteById(city.getCityId());
	return "City Deleted Successfully!" ;
}

public Optional<City> findById(long id) {
	return cityRepository.findById(id) ;
}

public City save(City city) {
	return cityRepository.save(city) ;
}

public City findOne(long Id){
	return cityRepository.findById(Id).get();
}
}