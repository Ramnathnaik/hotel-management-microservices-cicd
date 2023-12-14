package com.microservice.hotel.service;

import java.util.List;

import com.microservice.hotel.entity.Hotel;

public interface HotelService {
	
	//create hotel
	Hotel createHotel(Hotel hotel);
	
	//get all hotel
	List<Hotel> getHotels();
	
	//get single hotel
	Hotel getHotel(String id);

}
