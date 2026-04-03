package com.dev.MovieTicketApplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.MovieTicketApplication.dto.MovieDto;
import com.dev.MovieTicketApplication.entity.Movie;
import com.dev.MovieTicketApplication.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
	
	private final MovieService movieService;
	
	@PostMapping("/addMovie")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Movie> addMovie(@RequestBody MovieDto movieDto) {
		return ResponseEntity.ok(movieService.addMovie(movieDto));
	}
	
	// write the getAllmovies method here
	
	 @GetMapping("/getallMovies")
     public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(movieService.getAllMovies());		
     }
     
	 
	 // get movie by genre 
	 
	 @GetMapping("/getMoviesByGenre")
	 public ResponseEntity<List<Movie>> getMoviesByGenre(@RequestParam String genre) {
		 return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
	 }
	 
	 
	 // get movie by language using request param and annotated with get mapping
	 
	 @GetMapping("/getMoviesByLanguage")
	 public ResponseEntity<List<Movie>> getMoviesByLanguage(@RequestParam String language) {
		 return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
	 }
	 
	 // get movie by name using request param and annotated with get mapping
	 
	 @GetMapping("/getMoviesByName")
	 public ResponseEntity<List<Movie>> getMoviesByName(@RequestParam String name) {
		 return ResponseEntity.ok(movieService.getMoviesByName(name));
	 }
	 
	// update the movie details using pathvariable id and request body movie dto and annotated with put mapping
	 
	 @PutMapping("/updateMovie/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	 public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
		 return ResponseEntity.ok(movieService.updateMovie(id, movieDto));
	 }
	 
	 // delete the movie using id and use path variable and use the build method 
	 
	 @DeleteMapping("/deleteMovie/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	 public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		 movieService.deleteMovie(id);
		 return ResponseEntity.ok().build();
	 }
	  
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 