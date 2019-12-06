package com.khalil.repo;

import org.springframework.data.repository.CrudRepository;

import com.khalil.dao.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>{
	Genre findByName(String name);
}
