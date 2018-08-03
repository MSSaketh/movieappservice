package com.stackroute.movieappservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stackroute.movieappservice.domain.Movies;
import com.stackroute.movieappservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieappservice.exceptions.MovieNotFoundException;
import com.stackroute.movieappservice.repository.MoviesRepository;

@Service
@Qualifier("id1")
public class MovieServiceDummyImpl implements MoviesService {

	private MoviesRepository moviesRepo;

	@Autowired
	public MovieServiceDummyImpl(MoviesRepository moviesRepo) {
		super();
		this.moviesRepo = moviesRepo;
	}

	@Override
	public Movies saveMovie(Movies movie) throws MovieAlreadyExistsException {
		return null;
	}

	@Override
	public List<Movies> getAllMovies() {
		System.out.println("getall");
		return null;
	}

	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		return false;
	}

	@Override
	public Movies getMovieId(int movieId) {
		return null;
	}

	@Override
	public Movies updateMovie(Movies movie) {
		return null;
	}

	@Override
	public List<Movies> getMovieByName(String movieTitle) {
		return null;
	}

}
