package com.softwareinstitute.andreeaholban.moviesProject;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByUsernameAndPassword(String username, String password);
}
