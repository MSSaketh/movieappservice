package com.stackroute.movieappservice.services;

import java.util.List;

import com.stackroute.movieappservice.domain.Movies;
import com.stackroute.movieappservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieappservice.exceptions.MovieNotFoundException;

public interface MoviesService {

	public Movies saveMovie(Movies movie) throws MovieAlreadyExistsException;

	public List<Movies> getAllMovies();

	public boolean deleteMovie(int movieId) throws MovieNotFoundException;

	public Movies getMovieId(int movieId);

	public Movies updateMovie(Movies movie);

	public List<Movies> getMovieByName(String movieTitle);

}
