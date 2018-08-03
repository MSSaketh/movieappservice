package com.stackroute.movieappservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.movieappservice.domain.Movies;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

	Movies getByMovieId(int movieId);

	@Query("SELECT m FROM Movies m WHERE m.movieTitle like :movieTitle%")
	public List<Movies> getByMovieTitle(@Param("movieTitle") String movieTitle);

}
