package com.dev.MovieTicketApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.MovieTicketApplication.entity.Movie;
import com.dev.MovieTicketApplication.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

	Optional<List<Show>> findByMovie(Long movieId);

	Optional<List<Show>> findByTheater(Long theaterId);

}
