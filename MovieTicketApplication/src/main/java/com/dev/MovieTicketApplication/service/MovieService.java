package com.dev.MovieTicketApplication.service;

import java.util.List;

import com.dev.MovieTicketApplication.dto.MovieDto;
import com.dev.MovieTicketApplication.entity.Movie;

public interface MovieService {

	Movie addMovie(MovieDto movieDto);

	List<Movie> getAllMovies();

	List<Movie> getMoviesByGenre(String genre);

	List<Movie> getMoviesByLanguage(String language);

	List<Movie> getMoviesByName(String name);

	Movie updateMovie(Long id, MovieDto movieDto);

	void deleteMovie(Long id);

}
