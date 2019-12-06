package com.khalil.repo;

import org.springframework.data.repository.CrudRepository;

import com.khalil.dao.EditorsChoice;

public interface EditorsChoiceRepository extends CrudRepository<EditorsChoice, Long> {
	EditorsChoice findByValue(String value);
}


