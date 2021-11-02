package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

	@PostMapping("/deleteMovie")
	public @ResponseBody String deleteMovie (@RequestParam int id){
		movieRepository.deleteById(id);
		return "Deleted";
	}

	@PostMapping("/updateMovie")
	public @ResponseBody String updateMovie (@RequestParam int id, @RequestParam String title,
											 @RequestParam int length){
		Optional<Film> movie = movieRepository.findById(id);
		Film film = movie.get();
		film.setTitle(title);
		film.setLength(length);
		movieRepository.save(film);
		return "Movie updated";
	}

}
