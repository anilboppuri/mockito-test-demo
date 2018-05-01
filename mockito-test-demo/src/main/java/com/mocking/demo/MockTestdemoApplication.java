package com.mocking.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mocking.demo.entities.Hotel;
import com.mocking.demo.repository.HotelRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = HotelRepository.class)
public class MockTestdemoApplication implements CommandLineRunner{

	@Autowired
	private HotelRepository repo;
	
	/*public MockTestdemoApplication(HotelRepository repo) {
		
		this.repo = repo;
	}*/
	public static void main(String[] args) {
		SpringApplication.run(MockTestdemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
		Hotel taj = new Hotel();
		taj.setName("Taj Banjara");
		taj.setRooms(200);
		taj.setTariff(12000);
		
		Hotel tulip = new Hotel();
		tulip.setName("Tulip Manohar");
		tulip.setRooms(300);
		tulip.setTariff(15000);
		
		
		Hotel lemon = new Hotel();
		lemon.setName("Lenon Tree");
		lemon.setRooms(250);
		lemon.setTariff(16000);

		
		List<Hotel> hotels = Arrays.asList(taj,tulip,lemon);
		repo.save(hotels);
		
	}
}
