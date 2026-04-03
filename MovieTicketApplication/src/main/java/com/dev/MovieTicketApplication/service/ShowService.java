package com.dev.MovieTicketApplication.service;

import java.util.List;

import com.dev.MovieTicketApplication.dto.ShowDto;
import com.dev.MovieTicketApplication.entity.Show;

public interface ShowService {

	Show createShow(ShowDto show);

	List<Show> getAllShows();

	List<Show> getShowByMovieName(Long movieId);

	List<Show> getShowByTheaterName(Long theaterId);

	Show updateShow(ShowDto show, Long showId);

	void deleteShow(Long id);
}
