package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
@RequestMapping("/movies")
public class MoviesProjectApplication {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}

	@GetMapping("/getActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/all")
	public @ResponseBody
	Iterable<Film> getAllMovies
			() {
		return movieRepository.findAll();
	}

	@PostMapping("/addMovie")
	public @ResponseBody String addAMovie (@RequestParam String title
			, @RequestParam int length) {


		Film savedMovie = new Film(title, length);
		movieRepository.save(savedMovie);
		return "Saved";

	}

	public MovieRepository getMovieRepository() {
		return movieRepository;
	}

	public ActorRepository getActorRepository() {
		return actorRepository;
	}

}
