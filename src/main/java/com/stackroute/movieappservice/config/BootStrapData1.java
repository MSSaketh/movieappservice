package com.stackroute.movieappservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.stackroute.movieappservice.domain.Movies;
import com.stackroute.movieappservice.repository.MoviesRepository;

public class BootStrapData1 implements ApplicationListener<ApplicationEvent> {
	
	private MoviesRepository movieRepository;
	
	@Autowired
	public BootStrapData1(MoviesRepository movieRepository) {
		// super();
		this.movieRepository = movieRepository;
		// this.movie = movie;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("onApp");
		 Movies movie = new Movies();
				 movie.setMovieTitle("lagan");
				 movieRepository.save(movie);
				 Movies testMovie = Movies.builder()
				 .movieTitle("foo")
				 .movieRating(8.1)
				 .movieYear(2012)
				 .build();
				 movieRepository.save(testMovie);
				 Movies testMovie1 = Movies.builder()
				 .movieTitle("boo")
				 .movieRating(8.8)
				 .movieYear(2012)
				 .build();
				 movieRepository.save(testMovie1);
				
	}

}
