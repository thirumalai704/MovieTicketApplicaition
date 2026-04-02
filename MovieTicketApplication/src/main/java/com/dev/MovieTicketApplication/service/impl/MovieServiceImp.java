package com.dev.MovieTicketApplication.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.MovieTicketApplication.dto.MovieDto;
import com.dev.MovieTicketApplication.entity.Movie;
import com.dev.MovieTicketApplication.repository.MovieRepository;
import com.dev.MovieTicketApplication.service.MovieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {

	private final MovieRepository movieRepository;

	private final ModelMapper modelMapper;

	@Override
	public Movie addMovie(MovieDto movieDto) {

		Movie movie = modelMapper.map(movieDto, Movie.class);

		Movie savedMovie = movieRepository.save(movie);

		// Use Optional to verify save result
		return Optional.ofNullable(savedMovie)
				.orElseThrow(() -> new RuntimeException("Failed to save movie"));
	}

	@Override
	public List<Movie> getAllMovies() {
		// Delegate to repository and guard against nulls using Optional
		List<Movie> movies = movieRepository.findAll();
		return Optional.ofNullable(movies).orElse(Collections.emptyList());
	}

	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		List<Movie> movies = movieRepository.findByGenre(genre);
		return Optional.ofNullable(movies).orElse(Collections.emptyList());
	}

	@Override
	public List<Movie> getMoviesByLanguage(String language) {
		List<Movie> movies = movieRepository.findByLanguage(language);
		return Optional.ofNullable(movies).orElse(Collections.emptyList());
	}

	@Override
	public List<Movie> getMoviesByName(String name) {
		List<Movie> movies = movieRepository.findByNameContainingIgnoreCase(name);
		return Optional.ofNullable(movies).orElse(Collections.emptyList());
	}

	@Override
	public Movie updateMovie(Long id, MovieDto movieDto) {
		// Use Optional to verify existence
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		if (!optionalMovie.isPresent()) {
			throw new RuntimeException("Movie not found with id: " + id);
		}

		Movie movie = optionalMovie.get();

		// Map fields from DTO into existing entity (preserve id and relationships)
		modelMapper.map(movieDto, movie);
		movie.setId(id);

		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		// Use Optional to verify existence before delete
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		if (!optionalMovie.isPresent()) {
			throw new RuntimeException("Cannot delete - movie not found with id: " + id);
		}

		movieRepository.delete(optionalMovie.get());

	}

}