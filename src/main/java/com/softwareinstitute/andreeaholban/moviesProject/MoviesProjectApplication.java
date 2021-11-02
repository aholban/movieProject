package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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


	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}


	public Optional<User> login(String username, String password){
		Optional<User> found = userRepository.findOneByUsernameAndPassword(username, password);
		return found;
	}

	public Optional<User> findUser(String username){
		Optional<User> found = userRepository.findOneByUsername(username);
		return found;
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
		if(newAdminOptional.isPresent() && userOptional.isPresent()){
			User newAdmin = newAdminOptional.get();
			User user = userOptional.get();
			user.givePrivileges(newAdmin);
			userRepository.save(newAdmin);
		}
		return "Set new privileges";
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


	@PostMapping("/updateMovie")
	public @ResponseBody String updateMovie (@RequestParam String username, @RequestParam String password,
											 @RequestParam int id, @RequestParam String title,
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
			Film movie = movieOptional.get();
			return movie;
		}

		else return null;
	}

}
