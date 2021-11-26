package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://54.175.144.27:3000")
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

	private User thisUser;


	public static void main(String[] args) {
		SpringApplication.run(MoviesProjectApplication.class, args);
	}

	@PostMapping("/login")
	public @ResponseBody String login(@RequestParam String username, @RequestParam String password){
		String output = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			//thisUser = userOptional.get();
			output = "Logged in successfully";
		}
		else output = "Username and password not recognized";

		return output;

	}

	@GetMapping("/signout")
	public @ResponseBody String signout(){
		thisUser = null;
		return "Signed out";
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
	public @ResponseBody String addAMovie (@RequestParam String username, @RequestParam String password,
										   @RequestParam String title, @RequestParam int length) {

		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				Film savedMovie = new Film(title, length);
				movieRepository.save(savedMovie);
				message = "Saved";
			}
			else message ="You are not an admin";
		}else message = "Please log in first";

		return message;

	}

	@PostMapping("/addGenre")
	public @ResponseBody String addAGenre (@RequestParam String username, @RequestParam String password,
										   @RequestParam String name) {

		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		Optional<Genre> optionalGenre = genreRepository.findOneByName(name);
		if(optionalGenre.isPresent()) message="Genre already exists";
		else if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				Genre savedGenre = new Genre(name);
				genreRepository.save(savedGenre);
				message = "Saved";
			}
			else message ="You are not an admin";
		}else message = "Please log in first";

		return message;

	}

	@PostMapping("/addActor")
	public @ResponseBody String addAnActor (@RequestParam String username, @RequestParam String password,
										   @RequestParam String first_name, @RequestParam String last_name) {

		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				Actor savedActor = new Actor(first_name, last_name);
				actorRepository.save(savedActor);
				message = "Saved";
			}
			else message ="You are not an admin";
		}else message = "Please log in first";

		return message;

	}

	@PostMapping("rateMovie/{id}")
	public @ResponseBody String rateMovie(@PathVariable int id, @RequestParam double rating){
		String message = "";
		Optional<Film> movieOptional = movieRepository.findById(id);
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
		//thisUser = user;
		return "User saved";
	}

	@PostMapping("/makeAdmin")
	public @ResponseBody String makeAdmin(@RequestParam String user){
		Optional<User> newAdminOptional = userRepository.findOneByUsername(user);
		String message = "";
		if(!newAdminOptional.isPresent()) message = "Username not recognized";
		else if(thisUser==null) message = "You are not logged in";
		else {
			User newAdmin = newAdminOptional.get();
			message = thisUser.givePrivileges(newAdmin);
			userRepository.save(newAdmin);
		}
		return message;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteMovie/{id}")
	public @ResponseBody String deleteMovie (@PathVariable int id, @RequestParam String username, @RequestParam String password){
		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				movieRepository.deleteById(id);
				message = "Deleted";
			}
			else message = "You do not have permission to delete it";
		}
		else message = "You are not logged in";
		return message;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteGenre/{id}")
	public @ResponseBody String deleteGenre (@PathVariable int id, @RequestParam String username, @RequestParam String password){
		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				Genre genre = genreRepository.findById(id).get();
				for ( Film movie: genre.moviesInGenre
				) {
					movie.genres.remove(genre);
					movieRepository.save(movie);
				}
				genreRepository.deleteById(id);
				message = "Deleted";
			}
			else message = "You do not have permission to delete it";
		}
		else message = "You are not logged in";
		return message;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteActor/{id}")
	public @ResponseBody String deleteActor (@PathVariable int id, @RequestParam String username, @RequestParam String password){
		String message = "";
		Optional<User> userOptional = userRepository.findOneByUsernameAndPassword(username, password);
		if(userOptional.isPresent()){
			if(userOptional.get().getAdmin()) {
				Actor actor = actorRepository.findById(id).get();
				for ( Film movie: actor.movies
					 ) {
					movie.actorsInMovie.remove(actor);
					movieRepository.save(movie);
				}
				actorRepository.deleteById(id);
				message = "Deleted";
			}
			else message = "You do not have permission to delete it";
		}
		else message = "You are not logged in";
		return message;
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/updateMovie/{id}")
	public @ResponseBody String updateMovie (@PathVariable int id,
											 @RequestParam String username, @RequestParam String password,
											 @RequestParam String title, @RequestParam int length){
		String message = "";
		Optional<Film> movie = movieRepository.findById(id);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		if(!movie.isPresent()) message = "Movie is not in the database";
		else if(!user.isPresent()) message = "You are not logged in";
		else {
			if(user.get().getAdmin()) {
				Film film = movie.get();
				film.setTitle(title);
				film.setLength(length);
				movieRepository.save(film);
				message = "Movie updated";
			}
			else message = "You do not have permission to update it";

		}
		return message;
	}

	@PostMapping("/searchMovie")
	public @ResponseBody Iterable<Film> findMovie(@RequestParam String title){
		List<Film> movies = movieRepository.findAllByTitleStartsWith(title);
		return movies;
	}

	@GetMapping("/getMovie/{id}")
	public @ResponseBody Film findMovieById(@PathVariable int id){
		Optional<Film> movieOptional = movieRepository.findById(id);
		if(movieOptional.isPresent()){
			return movieOptional.get();

		}

		else return null;
	}

	@GetMapping("/getGenre/{id}")
	public @ResponseBody Genre findGenreById(@PathVariable int id){
		Optional<Genre> genreOptional = genreRepository.findById(id);
		if(genreOptional.isPresent()){
			return genreOptional.get();

		}

		else return null;
	}

	@GetMapping("/getActor/{id}")
	public @ResponseBody Actor findActorById(@PathVariable int id){
		Optional<Actor> actorOptional = actorRepository.findById(id);
		if(actorOptional.isPresent()){
			return actorOptional.get();

		}

		else return null;
	}

	@GetMapping("/getActorsForMovie/{id}")
	public @ResponseBody Iterable<Actor> getActorsForMovie(@PathVariable int id){
		Optional<Film> movie = movieRepository.findById(id);
		if(movie.isPresent()) return movie.get().actorsInMovie;
		else return null;
	}

	@GetMapping("/getAllGenres")
	public @ResponseBody Iterable<Genre> getAllGenres(){
		return genreRepository.findAll();
	}

	@GetMapping("/getMoviesOfActor/{id}")
	public @ResponseBody Iterable<Film> getMoviesOfActor(@PathVariable int id){
		Optional<Actor> actor = actorRepository.findById(id);
		return actor.<Iterable<Film>>map(value -> value.movies).orElse(null);
	}

	@GetMapping("/getMoviesByGenre/{id}")
	public @ResponseBody Iterable<Film> getMoviesByGenre(@PathVariable int id){
		Optional<Genre> genre = genreRepository.findById(id);
		return genre.<Iterable<Film>>map(value -> value.moviesInGenre).orElse(null);
	}

	@GetMapping("/getGenresOfMovie/{id}")
	public @ResponseBody Iterable<Genre> getGenresOfMovie(@PathVariable int id){
		Optional<Film> movie = movieRepository.findById(id);
		return movie.<Iterable<Genre>>map(film -> film.genres).orElse(null);
	}

	@PostMapping("/addGenreToMovie/{id}")
	public @ResponseBody String addGenreToMovie(@PathVariable int id,
												@RequestParam String username, @RequestParam String password,
												@RequestParam String name){
		Optional<Film> movie = movieRepository.findById(id);
		Optional<Genre> genre = genreRepository.findOneByName(name);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		String message = "";
		if(!user.isPresent()) message="You are not logged in";
		else if(!user.get().getAdmin()) message ="You are not admin";
			else if(!movie.isPresent()) message = "Movie is not in database";
				else if(!genre.isPresent()) message = "Genre is not in database";
					else {
						Film film = movie.get();
						film.genres.add(genre.get());
						movieRepository.save(film);
						message = "Genre added";
		}
		return message;
	}

	@DeleteMapping("/deleteGenreFromMovie/{id}")
	public @ResponseBody String deleteGenreFromMovie(@PathVariable int id,
												@RequestParam String username, @RequestParam String password,
												@RequestParam String name){
		Optional<Film> movie = movieRepository.findById(id);
		Optional<Genre> genre = genreRepository.findOneByName(name);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		String message = "";
		if(!user.isPresent()) message="You are not logged in";
		else if(!user.get().getAdmin()) message ="You are not admin";
		else if(!movie.isPresent()) message = "Movie is not in database";
		else if(!genre.isPresent()) message = "Genre is not in the database";
		else {
			Film film = movie.get();
			if(film.genres.contains(genre.get())){
				film.genres.remove(genre.get());
				movieRepository.save(film);
				message = "Genre deleted";
			}
			else message = "Genre is not in the movie";
		}
		return message;
	}

	@PostMapping("/addActorToMovie/{id}")
	public @ResponseBody String addActorToMovie(@PathVariable int id,
												@RequestParam String username, @RequestParam String password,
												@RequestParam String first_name, String last_name){
		Optional<Film> movie = movieRepository.findById(id);
		Optional<Actor> actorOptional = actorRepository.findOneByFirstNameAndLastName(first_name, last_name);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		String message = "";
		if(!user.isPresent()) message="You are not logged in";
		else if(!user.get().getAdmin()) message ="You are not admin";
		else if(!movie.isPresent()) message = "Movie is not in database";
		else {
			Actor actor;
			if (actorOptional.isPresent()) {actor = actorOptional.get();}
			else {actor = new Actor(first_name, last_name);
				actorRepository.save(actor);}
			Film film = movie.get();
			film.actorsInMovie.add(actor);
			movieRepository.save(film);
			message = "Actor added";

		}
		return message;
	}

	@DeleteMapping("/deleteActorFromMovie/{id}")
	public @ResponseBody String deleteActorFromMovie(@PathVariable int id,
												@RequestParam String username, @RequestParam String password,
												@RequestParam String first_name, String last_name){
		Optional<Film> movie = movieRepository.findById(id);
		Optional<Actor> actorOptional = actorRepository.findOneByFirstNameAndLastName(first_name, last_name);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		String message = "";
		if(!user.isPresent()) message="You are not logged in";
		else if(!user.get().getAdmin()) message ="You are not admin";
		else if(!movie.isPresent()) message = "Movie is not in database";
		else {
			if (!actorOptional.isPresent()) {message = "Actor is not in the database";}
			else {

				Film film = movie.get();
				if(film.actorsInMovie.contains(actorOptional.get())){
					film.actorsInMovie.remove(actorOptional.get());
					movieRepository.save(film);
					message = "Actor deleted";
				}
				else message = "Actor is not in the movie";
			}
		}
		return message;
	}

	@PostMapping("addTrailerToMovie/{id}")
	public @ResponseBody String addTrailerToMovie(@PathVariable int id,
												  @RequestParam String username, @RequestParam String password,
												  @RequestParam String trailerID){
		Optional<Film> movie = movieRepository.findById(id);
		Optional<User> user = userRepository.findOneByUsernameAndPassword(username, password);
		String message = "";
		if(!user.isPresent()) message="You are not logged in";
		else if(!user.get().getAdmin()) message ="You are not admin";
		else if(!movie.isPresent()) message = "Movie is not in database";
		else{
			Film film = movie.get();
			film.setVideoID(trailerID);
			movieRepository.save(film);
			message="Trailer added";
		}
		return message;
	}


}
