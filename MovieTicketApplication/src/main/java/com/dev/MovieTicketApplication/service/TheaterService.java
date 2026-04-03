package com.dev.MovieTicketApplication.service;

import com.dev.MovieTicketApplication.dto.TheaterDto;
import com.dev.MovieTicketApplication.entity.Theater;

public interface TheaterService {

	Theater addTheater(TheaterDto theater);

	Theater updateTheater(Long theaterId, TheaterDto theater);

	void deleteTheater(Long theaterId);

	Theater getTheaterByLocation(String location);

}
