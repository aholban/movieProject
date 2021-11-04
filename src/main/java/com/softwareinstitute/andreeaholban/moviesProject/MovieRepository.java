package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface MovieRepository extends CrudRepository<Film, Integer>{
    Optional<Film> findOneByTitle(String title);

}
