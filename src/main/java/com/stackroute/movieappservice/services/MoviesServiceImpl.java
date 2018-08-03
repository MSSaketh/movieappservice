package com.stackroute.movieappservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stackroute.movieappservice.domain.Movies;
import com.stackroute.movieappservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieappservice.exceptions.MovieNotFoundException;
import com.stackroute.movieappservice.repository.MoviesRepository;

@Service
@Qualifier("id2")
public class MoviesServiceImpl implements MoviesService {

	private MoviesRepository moviesRepo;

	@Autowired
	public MoviesServiceImpl(MoviesRepository moviesRepo) {
		// super();
		this.moviesRepo = moviesRepo;
	}

	@Override
	public Movies saveMovie(Movies movie) throws MovieAlreadyExistsException {
		if (!moviesRepo.existsById(movie.getMovieId())) {
			Movies saveMovie = moviesRepo.save(movie);
			return saveMovie;
		} else {
			throw new MovieAlreadyExistsException("movie already exists");
		}

	}

	@Override
	public List<Movies> getAllMovies() {

		List<Movies> getMovies = (List<Movies>) moviesRepo.findAll();
		return getMovies;
	}

	@Override
	public Movies getMovieId(int movieId) {
		Movies getId = moviesRepo.getByMovieId(movieId);
		return getId;

	}

	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		boolean status = false;
		if (moviesRepo.existsById(movieId)) {
			Movies delMve = moviesRepo.getByMovieId(movieId);
			moviesRepo.delete(delMve);
			status = true;
		} else {
			throw new MovieNotFoundException("no movie id");

		}

		return status;
	}

	@Override
	public Movies updateMovie(Movies movie) {

		Movies mveUpdate = moviesRepo.save(movie);
		return mveUpdate;
	}

	@Override
	public List<Movies> getMovieByName(String movieTitle) {
		List<Movies> getMve = moviesRepo.getByMovieTitle(movieTitle);
		return getMve;
	}

}
