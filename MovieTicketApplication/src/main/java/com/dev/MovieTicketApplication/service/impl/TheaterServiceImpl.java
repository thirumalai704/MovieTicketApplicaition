package com.dev.MovieTicketApplication.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.MovieTicketApplication.dto.TheaterDto;
import com.dev.MovieTicketApplication.entity.Theater;
import com.dev.MovieTicketApplication.repository.TheaterRepository;
import com.dev.MovieTicketApplication.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

	private final TheaterRepository theaterRepository;
	
	private ModelMapper modelMapper;

	  // Add Theater
    @Override
    public Theater addTheater(TheaterDto dto) {

        Theater theater = modelMapper.map(dto, Theater.class);
        return theaterRepository.save(theater);
    }

    // Get Theater by Location
    @Override
    public Theater getTheaterByLocation(String location) {

        return theaterRepository.findByLocation(location)
                .orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    // Update Theater
    @Override
    public Theater updateTheater(Long theaterId, TheaterDto dto) {

        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        Theater updatedTheater = modelMapper.map(dto, Theater.class);
        updatedTheater.setId(theater.getId());
        
        return theaterRepository.save(theater);
    }

    // Delete Theater
    @Override
    public void deleteTheater(Long theaterId) {

        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        theaterRepository.delete(theater);
    }
}
