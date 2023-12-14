package com.microservice.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
