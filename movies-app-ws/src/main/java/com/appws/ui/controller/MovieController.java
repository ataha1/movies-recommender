package com.appws.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appws.ui.model.response.MovieRest;

@RestController
@RequestMapping("movie")   //http://localhost:8080/movies
public class MovieController {
	
	static String movieApi = "https://api.themoviedb.org/3/movie/";
	static String apiKey = "a97243d7813d31446f6c43284e6854d5";
	static String query = "?api_key=" + apiKey;
	
	@GetMapping(path = "/{movieId}") 
	public MovieRest getMovie(@PathVariable String movieId) {
		
		MovieRest returnMovie = new MovieRest();
		String url = movieApi + movieId + query;
		RestTemplate restTemplate = new RestTemplate();
		returnMovie = restTemplate.getForObject(url, MovieRest.class);
		
		
		return returnMovie;
	}
}
