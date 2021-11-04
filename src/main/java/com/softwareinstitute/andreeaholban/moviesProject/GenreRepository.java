package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Optional<Genre> findOneByName(String name);
}
