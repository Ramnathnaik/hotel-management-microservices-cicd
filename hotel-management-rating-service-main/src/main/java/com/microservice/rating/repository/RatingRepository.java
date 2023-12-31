package com.microservice.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.rating.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserId(String UserId);

	List<Rating> findByHotelId(String hotelId);

}
