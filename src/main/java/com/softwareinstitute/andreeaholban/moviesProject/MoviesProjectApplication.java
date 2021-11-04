package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GenreRepository genreRepository;


	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}

	public Optional<User> login(String username, String password){
		return userRepository.findOneByUsernameAndPassword(username, password);

	}

	public Optional<User> findUser(String username){
		return userRepository.findOneByUsername(username);

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

		String message = "";
		Optional<Film> film = movieRepository.findOneByTitle(title);
		if(film.isPresent()){
			message = "Movie already exists";
		}
		else {
			Film savedMovie = new Film(title, length);
			movieRepository.save(savedMovie);
			message = "Saved";
		}

		return message;

	}

	@PostMapping("rateMovie/{title}")
	public @ResponseBody String rateMovie(@PathVariable("title") String title, @RequestParam double rating){
		String message = "";
		Optional<Film> movieOptional = movieRepository.findOneByTitle(title);
		if(movieOptional.isPresent()){
			Film movie = movieOptional.get();
			movie.updateRating(rating);
			movieRepository.save(movie);
			message = "Star rating updated";
		}
		else message = "Movie not found";
		return message;
	}

	@PostMapping("/createUser")
	public @ResponseBody String createUser(@RequestParam String username, @RequestParam String password){
		User user = new User(username, password);
		userRepository.save(user);
		return "User saved";
	}

	@PostMapping("/makeAdmin")
	public @ResponseBody String makeAdmin(@RequestParam String currentUser, @RequestParam String password, @RequestParam String toUser){
		Optional<User> userOptional = login(currentUser, password);
		Optional<User> newAdminOptional = findUser(toUser);
		String message = "";
		if(newAdminOptional.isPresent() && userOptional.isPresent()){
			User newAdmin = newAdminOptional.get();
			User user = userOptional.get();
			message = user.givePrivileges(newAdmin);
			userRepository.save(newAdmin);
		}
		else message = "Username not recognized";
		return message;
	}

	@DeleteMapping("/deleteMovie/{id}")
	public @ResponseBody String deleteMovie (@PathVariable int id, @RequestParam String username, @RequestParam String password){
		String message = "";
		Optional<User> userOptional = login(username, password);
		if(userOptional.isPresent()){
			User user = userOptional.get();
			if(user.getAdmin()) {
				movieRepository.deleteById(id);
				message = "Deleted";
			}
			else message = "You do not have permission to delete it";
		}
		else message = "You are not registered";
		return message;
	}


	@PostMapping("/updateMovie/{id}")
	public @ResponseBody String updateMovie (@PathVariable int id,
											 @RequestParam String username, @RequestParam String password,
											 @RequestParam String title,
											 @RequestParam int length){
		String message = "";
		Optional<User> userOptional = login(username, password);
		Optional<Film> movie = movieRepository.findById(id);
		if(movie.isPresent() && userOptional.isPresent()){
			User user = userOptional.get();
			if(user.getAdmin()) {
				Film film = movie.get();
				film.setTitle(title);
				film.setLength(length);
				movieRepository.save(film);
				message = "Movie updated";
			}
			else message = "You do not have permission to update it";

		}
		else if(!movie.isPresent()) message = "Movie is not in the database";
		else message = "You are not registered";
		return message;
	}

	@PostMapping("/searchMovie")
	public @ResponseBody Film findMovie(@RequestParam String title){
		Optional<Film> movieOptional = movieRepository.findOneByTitle(title);
		if(movieOptional.isPresent()){
			return movieOptional.get();

		}

		else return null;
	}

	@GetMapping("/getActorsForMovie/{title}")
	public @ResponseBody Iterable<Actor> getActorsForMovie(@PathVariable String title){
		Optional<Film> movie = movieRepository.findOneByTitle(title);
		if(movie.isPresent()) return movie.get().actorsInMovie;
		else return null;
	}

	@GetMapping("/getAllGenres")
	public @ResponseBody Iterable<Genre> getAllGenres(){
		return genreRepository.findAll();
	}

	@GetMapping("/getMoviesByGenre/{name}")
	public @ResponseBody Iterable<Film> getMoviesByGenre(@PathVariable String name){
		Optional<Genre> genre = genreRepository.findOneByName(name);
		return genre.<Iterable<Film>>map(value -> value.moviesInGenre).orElse(null);
	}

	@GetMapping("/getGenresOfMovie/{title}")
	public @ResponseBody Iterable<Genre> getGenresOfMovie(@PathVariable String title){
		Optional<Film> movie = movieRepository.findOneByTitle(title);
		return movie.<Iterable<Genre>>map(film -> film.genres).orElse(null);
	}

}
