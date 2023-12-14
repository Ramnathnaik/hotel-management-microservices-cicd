package com.microservice.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.repository.HotelRepository;
import com.microservice.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getHotels() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return this.hotelRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Hotel with ID: " + id + " was found in records!"));
	}

}
