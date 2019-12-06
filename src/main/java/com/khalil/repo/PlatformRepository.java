package com.khalil.repo;

import org.springframework.data.repository.CrudRepository;

import com.khalil.dao.Platform;

public interface PlatformRepository extends CrudRepository<Platform, Long>{
	
	Platform findByName(String name);
}
