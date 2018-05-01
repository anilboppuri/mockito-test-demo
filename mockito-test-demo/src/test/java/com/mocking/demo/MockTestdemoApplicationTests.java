package com.mocking.demo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockTestdemoApplication.class)
@SpringBootTest
public class MockTestdemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void testAllHotels() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hotel/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", Matchers.hasSize(3))); // the test will
																// pass for 3 as
																// there are
																// only 3 hotels
																// in db
	}
	@Test
	public void testGivenIdHotelExists() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/hotel/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.name").value("Taj Banjara"))
				.andExpect(jsonPath("$.rooms").value(200)).andExpect(jsonPath("$.tariff").value(12000));
	}

	@Test
	public void testGetTariffById() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/hotel/tariff/3").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.tariff").value(16000));
	}
}
