package com.dev.MovieTicketApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.MovieTicketApplication.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByGenre(String genre);

    List<Movie> findByLanguage(String language);

    List<Movie> findByNameContainingIgnoreCase(String name);
}
