package com.mocking.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mocking.demo.entities.Hotel;


public interface HotelServiceIface {
	
	public Hotel getHotel(Integer id);
    public List<String> getHotelByNames();
    public List<Hotel> getHotels();
    public int getHotelByTariff(Integer id);

}
