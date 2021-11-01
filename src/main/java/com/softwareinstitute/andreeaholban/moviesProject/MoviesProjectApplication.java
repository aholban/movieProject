package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication
public class MoviesProjectApplication {

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}

	@GetMapping("/all")
	public @ResponseBody
	Iterable<Film> getAllUsers() {
		return movieRepository.findAll();
	}

}
