package com.dev.MovieTicketApplication.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
	
// write the field for title , description  ,genre ,language ,duration , release date
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name;
	private String description;
	private String genre;
	private Integer duration; // in minutes
	private LocalDate releaseDate; // can be changed to Date type if needed
	private String language;
	
	@OneToMany(mappedBy = "movie"  , fetch = FetchType.LAZY)
	private List<Show> shows; // One movie can have multiple shows


}
