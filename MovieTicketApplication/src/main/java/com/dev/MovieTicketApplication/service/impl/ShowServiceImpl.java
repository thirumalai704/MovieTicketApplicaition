package com.dev.MovieTicketApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.MovieTicketApplication.dto.ShowDto;
import com.dev.MovieTicketApplication.entity.Booking;
import com.dev.MovieTicketApplication.entity.Movie;
import com.dev.MovieTicketApplication.entity.Show;
import com.dev.MovieTicketApplication.entity.Theater;
import com.dev.MovieTicketApplication.repository.MovieRepository;
import com.dev.MovieTicketApplication.repository.ShowRepository;
import com.dev.MovieTicketApplication.repository.TheaterRepository;
import com.dev.MovieTicketApplication.service.ShowService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

	private final MovieRepository movieRepository;

	private final ShowRepository showRepository;

	private final TheaterRepository theaterRepository;

	private final ModelMapper modelMapper;

	@Override
	public Show createShow(ShowDto show) {

		Movie movie = movieRepository.findById(show.getMovieId())
				.orElseThrow(() -> new RuntimeException("Movie not found with id: " + show.getMovieId()));

		Theater theater = theaterRepository.findById(show.getTheaterId())
				.orElseThrow(() -> new RuntimeException("Theater not found with id: " + show.getTheaterId()));

		Show showEntity = modelMapper.map(show, Show.class);

		return showRepository.save(showEntity);
	}

	@Override
	public List<Show> getAllShows() {
		return showRepository.findAll();
	}

	@Override
	public Show updateShow(ShowDto show , Long id) {
		
		Movie movie = movieRepository.findById(show.getMovieId())
				.orElseThrow(() -> new RuntimeException("Movie not found with id: " + show.getMovieId()));

		Theater theater = theaterRepository.findById(show.getTheaterId())
				.orElseThrow(() -> new RuntimeException("Theater not found with id: " + show.getTheaterId()));

		Show showEntity = modelMapper.map(show, Show.class);

		return showRepository.save(showEntity);
		
	}

	@Override
	public void deleteShow(Long id) {
	   if(!showRepository.existsById(id)) {
		   throw new RuntimeException("Show not found with id: " + id);
	   }
	   
	   List<Booking> bookings = showRepository.findById(id)
			   .orElseThrow(() -> new RuntimeException("Show not found with id: " + id))
			   .getBookings();
	}

	@Override
	public List<Show> getShowByMovieName(Long movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new RuntimeException("Movie not found with id: " + movieId));

		Optional<List<Show>> shows = showRepository.findByMovie(movieId);

		if (shows.isPresent()) {
			return shows.get();
		} else {
			throw new RuntimeException("No shows found for movie with id: " + movieId);
		}
	}

	@Override
	public List<Show> getShowByTheaterName(Long theaterId) {

		Theater theater = theaterRepository.findById(theaterId)
				.orElseThrow(() -> new RuntimeException("theater not found with id: " + theaterId));

		Optional<List<Show>> shows = showRepository.findByTheater(theaterId);

		if (shows.isPresent()) {
			return shows.get();
		} else {
			throw new RuntimeException("No shows found for movie with id: " + theaterId);
		}

	}

}
