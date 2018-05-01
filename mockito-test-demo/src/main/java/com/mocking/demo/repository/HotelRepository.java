package com.mocking.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mocking.demo.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	public Hotel findById(Integer id);
	public List<Hotel> findAll();
	public Integer findHotelByTariff(Integer id);

}
