package com.khalil.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khalil.dao.Game;
import com.khalil.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(path="/games")
	public Iterable<Game> games() {
		return gameService.findall();
	}
	
	@PostMapping(path="/games")
	public Game addGame(@RequestBody Game game) {
		return gameService.addGame(game);
	}
	
	@PatchMapping(path="/games")
	public Game updateGame(@RequestBody Game game) {
		return gameService.addGame(game);
	}
	
	@GetMapping(path="/games/{id}")
	public Optional<Game> findGame(@PathVariable Long id) {
		return gameService.findById(id);
	}
	
	@DeleteMapping(path="/games/{id}")
	public void delteGame(@PathVariable Long id) {
		gameService.deleteById(id);
	}
}
