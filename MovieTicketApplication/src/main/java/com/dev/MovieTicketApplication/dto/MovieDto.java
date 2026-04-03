package com.dev.MovieTicketApplication.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieDto {
	
	private String name;
	private String description;
	private String genre;
	private Integer duration; // in minutes
	private LocalDate releaseDate; // can be changed to Date type if needed
	private String language;

}
