package com.khalil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khalil.dao.Game;
import com.khalil.repo.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	
	public Iterable<Game> findall() {
		return gameRepository.findAll();
	}
	
	public Game addGame(Game game) {
		return gameRepository.save(game);
	}

	
	
	public Optional<Game> findById(Long id) {
		return gameRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		gameRepository.deleteById(id);
	}
	
}
