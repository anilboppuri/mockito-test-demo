package com.mocking.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hotel" , catalog="test")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int rooms;
	private int tariff;
	
	
	public Hotel() {
		
	}
	
	


	public Hotel(String name, int rooms, int tariff) {
		super();
		this.name = name;
		this.rooms = rooms;
		this.tariff = tariff;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRooms() {
		return rooms;
	}


	public void setRooms(int rooms) {
		this.rooms = rooms;
	}


	public int getTariff() {
		return tariff;
	}


	public void setTariff(int tariff) {
		this.tariff = tariff;
	}
	
	

}
