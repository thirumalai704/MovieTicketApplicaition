package com.dev.MovieTicketApplication.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ShowDto {
	
    private LocalDateTime showTime;
    private Double price ;
    private Long MovieId;
    private Long TheaterId;

}
