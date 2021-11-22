package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actor, Integer>{
    Optional<Actor> findOneByFirstNameAndLastName(String firstName, String lastName);
}
