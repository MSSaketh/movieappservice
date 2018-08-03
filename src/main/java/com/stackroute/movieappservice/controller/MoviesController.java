package com.stackroute.movieappservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.movieappservice.domain.Movies;
import com.stackroute.movieappservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieappservice.exceptions.MovieNotFoundException;
import com.stackroute.movieappservice.services.MoviesService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class MoviesController {

//	@Qualifier("abcd")
//	@Autowired
	private MoviesService moviesService;

	@Autowired
	public MoviesController(@Qualifier("id2")MoviesService moviesService) {
		// super();
		this.moviesService = moviesService;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovieHandler(@RequestBody Movies movie) {
		try {
			Movies movieObj = moviesService.saveMovie(movie);

			return new ResponseEntity<Movies>(movieObj, HttpStatus.OK);

		} catch (MovieAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Movies>> getAllMoviesHAndler() {

		List<Movies> movieObj = moviesService.getAllMovies();
		return new ResponseEntity<List<Movies>>(movieObj, HttpStatus.OK);

	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteMovieHandler(@PathVariable int id) {
		try {
			moviesService.deleteMovie(id);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>("no movie id in the list", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/movie", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Movies> updateMovieHandler(@RequestBody Movies movie) {
		Movies updateMve = moviesService.updateMovie(movie);
		return new ResponseEntity<Movies>(updateMve, HttpStatus.OK);

	}

	@RequestMapping(value = "/movies/{name}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Movies>> getMovieByName(@PathVariable String name) {

		List<Movies> movieObj = moviesService.getMovieByName(name);
		return new ResponseEntity<List<Movies>>(movieObj, HttpStatus.OK);

	}
}
