package com.dev.MovieTicketApplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketApplication.class, args);
	}
	
	// create the bean for model mapper and return the model mapper object
	
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
