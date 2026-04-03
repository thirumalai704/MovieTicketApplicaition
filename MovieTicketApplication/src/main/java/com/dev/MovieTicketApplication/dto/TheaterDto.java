package com.dev.MovieTicketApplication.dto;

import lombok.Data;

@Data
public class TheaterDto {

	private String name;
	private String location;
	private Integer theaterCapacity;
	private String ScreeningType;
}
