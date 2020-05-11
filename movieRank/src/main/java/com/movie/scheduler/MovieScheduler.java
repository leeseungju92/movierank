package com.movie.scheduler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MovieScheduler {
	
	@Autowired 
	MovieService mService;
	
	@Scheduled(cron = "0 3 10 * * *")
	public void moviecollect() throws IOException {				
		log.info(">>>> 크롤 시작");
		mService.ticketRank();
	}
	
} 
 