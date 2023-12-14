package com.microservice.rating.service;

import java.util.List;

import com.microservice.rating.entity.Rating;

public interface RatingService {
	
	//create rating
	Rating createRating(Rating rating);
	
	//get all ratings
	List<Rating> getRatings();
	
	//get ratings by user id
	List<Rating> getRatingByUserId(String userId);
	
	//get ratings by hotel id
	List<Rating> getRatingByHotelId(String hotelId);

}
