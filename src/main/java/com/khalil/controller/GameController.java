package com.khalil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalil.dao.Game;

@RestController
public class GameController {
	
	@GetMapping(path="/games")
	public Game games() {
		return new Game();
	}
}
