package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


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

	@PostMapping("/addMovie")
	public @ResponseBody String addAMovie (@RequestParam String title
			, @RequestParam int length) {


		Film savedMovie = new Film(title, length);
		movieRepository.save(savedMovie);
		return "Saved";

	}

}
