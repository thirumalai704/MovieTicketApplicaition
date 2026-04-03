package com.dev.MovieTicketApplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.MovieTicketApplication.dto.ShowDto;
import com.dev.MovieTicketApplication.entity.Show;
import com.dev.MovieTicketApplication.service.ShowService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {
	
	private final ShowService showService;
	
	
	// write the code for creating a show, getting all shows, getting a show by id, updating a show and deleting a show
	
	@PostMapping("/createshow")
	public ResponseEntity<Show> createShow(@RequestBody ShowDto show) {
		return ResponseEntity.ok(showService.createShow(show));
	}
	
	@GetMapping("/getshows")
	public ResponseEntity<List<Show>> getAllShows() {
		return ResponseEntity.ok(showService.getAllShows());
	}
	
	// write the code for getting a show by using movie name 
	
	@GetMapping("/getshowbymoviename/{movieId}")
	public ResponseEntity<List<Show>> getShowByMovieName(@PathVariable Long movieId) {
		return ResponseEntity.ok(showService.getShowByMovieName(movieId));
	}
	
	
    // write the code for getting the show by using theater name and use the param
	
	@GetMapping("/getshowbytheatername/{theaterId}")
	public ResponseEntity<List<Show>> getShowByTheaterName(@PathVariable Long theaterId) {
		return ResponseEntity.ok(showService.getShowByTheaterName(theaterId));
	}
	
	@PutMapping("/updateshow/{showId}")
	public ResponseEntity<Show> updateShow(@RequestBody ShowDto show , Long showId) {
		return ResponseEntity.ok(showService.updateShow(show,showId));
	}
	
	@DeleteMapping("/deleteshow/{id}")
	public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
		showService.deleteShow(id);
		return ResponseEntity.ok().build();
	}
	
}

