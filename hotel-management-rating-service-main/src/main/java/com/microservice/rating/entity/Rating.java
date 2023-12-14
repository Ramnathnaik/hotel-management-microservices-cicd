package com.microservice.rating.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Using lombok to generate getter and setter, 
 * But lombok is not working. Hence defining the getters and setters manually
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String feedback;

}
