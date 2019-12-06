package com.khalil.repo;

import org.springframework.data.repository.CrudRepository;

import com.khalil.dao.Game;

public interface GameRepository extends CrudRepository<Game, Long> {

}
