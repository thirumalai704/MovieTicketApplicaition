package com.dev.MovieTicketApplication.controller;

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

import com.dev.MovieTicketApplication.dto.TheaterDto;
import com.dev.MovieTicketApplication.entity.Theater;
import com.dev.MovieTicketApplication.service.TheaterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterContoller {
	
	private final TheaterService theaterService;
	
	// write the method post for add theater
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Theater> addTheater(@RequestBody TheaterDto theater) {
		Theater savedTheater = theaterService.addTheater(theater);
		return ResponseEntity.ok(savedTheater);
	}
	
	// get the theater using location and use request param for location
	
	@GetMapping("/get")
	public ResponseEntity<Theater> getTheaterByLocation(@RequestParam String location) {
		Theater theater = theaterService.getTheaterByLocation(location);
		return ResponseEntity.ok(theater);
	}
	
	// write the put method for update theater using theater id and use the path valiable for theater id
	
	@PutMapping("/update/{theaterId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Theater> updateTheater(@PathVariable Long theaterId, @RequestBody TheaterDto theater) {
		Theater updatedTheater = theaterService.updateTheater(theaterId, theater);
		return ResponseEntity.ok(updatedTheater);
	}
	
	
	// write the delete method for delete theater using theater id and use the path valiable for theater id
	
	@DeleteMapping("/delete/{theaterId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> deleteTheater(@PathVariable Long theaterId) {
		theaterService.deleteTheater(theaterId);
		return ResponseEntity.noContent().build();
	}

}
