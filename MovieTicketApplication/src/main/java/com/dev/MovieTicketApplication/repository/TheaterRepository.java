package com.dev.MovieTicketApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.MovieTicketApplication.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
	 Optional<Theater> findByLocation(String location);
}
