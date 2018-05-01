package com.mocking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mocking.demo.entities.Hotel;
import com.mocking.demo.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	public static final String URL = "http://localhost:8080/hotel/all";
	@Autowired 
	private HotelService service;

	@GetMapping("/{id}")
	public Hotel giveHotelName(@PathVariable("id") Integer id) {

		if (service != null) {
			Hotel hotel = service.getHotel(id);
			return hotel;
		}
		return new Hotel();
	}
	
	@GetMapping("/all")
	public List<Hotel> getAllHotels(){
		
		return service.getHotels();
	}
	
	
	@GetMapping("/tariff/{id}")
	public int getHotelTariff(@PathVariable("id") Integer id){
		
		return service.getHotelByTariff(id);
	}

}
