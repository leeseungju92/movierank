package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	@Autowired
	MovieService mService;
	@RequestMapping("/")
	public String index(Model model) {
		
		log.info(">>>>INDEX PAGE VIEW");
		model.addAttribute("rankList",mService.movieList());
		return "index";
		
	}
}
