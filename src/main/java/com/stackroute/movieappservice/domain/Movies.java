package com.stackroute.movieappservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieTitle;
	private double movieRating;
	private int movieYear;

}
