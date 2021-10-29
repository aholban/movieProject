package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@SpringBootApplication
public class MoviesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}

	@GetMapping("/getmovietitle")
	public String movieResponse(){
		Movie movie = new Movie("Suicide Squad 2");

		return movie.getJasonObjectOfMovie();
	}

}
