package com.cg.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.model.City;
import com.cg.demo.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City c);
}
