package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.softwareinstitute.andreeaholban.moviesProject.MoviesProjectApplication.*;

@SpringBootTest
public class MoviesProjectApplicationTest {

	@Autowired
	private MovieRepository testRepository;

	@Test
	public void contextLoads() {
	}

}
