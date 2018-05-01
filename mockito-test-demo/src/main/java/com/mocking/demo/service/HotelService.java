package com.mocking.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mocking.demo.entities.Hotel;
import com.mocking.demo.repository.HotelRepository;

@Service
public class HotelService implements HotelServiceIface {

	@Autowired
	private HotelRepository repository;

     	
	
	/*public HotelService(HotelRepository repository) {
	
		this.repository = repository;
	}*/



	@Override
	public Hotel getHotel(Integer id) {
		Hotel hotel= null;
		
		if(repository != null)
		return repository.findById(id);
         

		else
			return null;
	}



	@Override
	public List<String> getHotelByNames() {
		
		List<Hotel> hotels = repository.findAll();
		List<String> temp = new ArrayList<>(); 
		for(Hotel hotel : hotels)
			temp.add(hotel.getName());
	
	 return temp;
	}



	@Override
	public int getHotelByTariff(Integer id) {
	
		System.out.println(repository.findById(id).getName());
		return repository.findById(id).getTariff();
		
	}



	@Override
	public List<Hotel> getHotels() {
		
		return repository.findAll();
	}
}
