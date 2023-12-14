package com.microservice.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel hotel2 = this.service.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> hotels = this.service.getHotels();
		return ResponseEntity.ok(hotels);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
		Hotel hotel = this.service.getHotel(id);
		return ResponseEntity.ok(hotel);
	}

}
