package com.stackroute.movieappservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.stackroute.movieappservice.repository.MoviesRepository;

@Configuration
public class BootStrapData implements CommandLineRunner {

	private MoviesRepository movieRepository;

//	@Autowired
//	public BootStrapData(MoviesRepository movieRepository) {
//		// super();
//		this.movieRepository = movieRepository;
//		// this.movie = movie;
//	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("commandline runner");
		// Movies movie = new Movies();
		// movie.setMovieTitle("lagan");
		// movieRepository.save(movie);
		// Movies testMovie = Movies.builder()
		// .movieTitle("foo")
		// .movieRating(8.1)
		// .movieYear(2012)
		// .build();
		// movieRepository.save(testMovie);
		// Movies testMovie1 = Movies.builder()
		// .movieTitle("boo")
		// .movieRating(8.8)
		// .movieYear(2012)
		// .build();
		// movieRepository.save(testMovie1);
		
	}

	// @Override
	// public void onApplicationEvent(ContextRefreshedEvent event) {
	// Movies movie = new Movies();
	// movie.setMovieTitle("lagan");
	// movieRepository.save(movie);
	// Movies testMovie = Movies.builder()
	// .movieTitle("foo")
	// .movieRating(8.1)
	// .movieYear(2012)
	// .build();
	// movieRepository.save(testMovie);
	// Movies testMovie1 = Movies.builder()
	// .movieTitle("boo")
	// .movieRating(8.8)
	// .movieYear(2012)
	// .build();
	// movieRepository.save(testMovie1);
	//
	// }

}
