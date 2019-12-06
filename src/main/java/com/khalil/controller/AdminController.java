package com.khalil.controller;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalil.dao.EditorsChoice;
import com.khalil.dao.Game;
import com.khalil.dao.Genre;
import com.khalil.dao.Platform;
import com.khalil.repo.EditorsChoiceRepository;
import com.khalil.repo.GameRepository;
import com.khalil.repo.GenreRepository;
import com.khalil.repo.PlatformRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

@RestController
public class AdminController {
	
	@Autowired
	private PlatformRepository platformRepository;
	
	@Autowired
	private EditorsChoiceRepository editorsChoiceRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping("/admin/loadcsv")
	public String loadCSV() throws Exception {
        Reader reader = new FileReader("D:\\data\\gamesc2b2088.csv");  
		List<String[]> list = new ArrayList<>();
		CSVReader csvReader = new CSVReader(reader);
		String[] line;
		line = csvReader.readNext();
		while ((line = csvReader.readNext()) != null) {
			list.add(line);
			getGame(line);
		}
		reader.close();
		csvReader.close();
		return "hello";
	}

	private Game getGame(String[] line) throws Exception {
		Game game = new Game();
		
		game.setTitle(line[0]);
		System.out.println(line[0]);
		Platform platform = platformRepository.findByName(line[1]);
		if ( platform == null ) {
			platform = new Platform();
			platform.setName(line[1]);
			platformRepository.save(platform);
		}
		game.setPlatform(platform);
		
		game.setScore(Float.parseFloat(line[2]));
		
		CSVParser csvParser = new CSVParser();
		String[] genreArray = csvParser.parseLine(line[3]);
		List<Genre> genreList = new ArrayList<Genre>();
		for ( String genreTemp : genreArray ) {
			Genre genre = genreRepository.findByName(genreTemp);
			if ( genre == null ) {
				genre = new Genre();
				genre.setName(genreTemp);
				genreRepository.save(genre);
			}
			genreList.add(genre);
			game.setGenre(genreList);
		}
		
		
		EditorsChoice editorsChoice = editorsChoiceRepository.findByValue(line[4]);
		if ( editorsChoice == null ) {
			editorsChoice = new EditorsChoice();
			editorsChoice.setValue(line[4]);
			editorsChoiceRepository.save(editorsChoice);
		}
		game.setEditorsChoice(editorsChoice);
		gameRepository.save(game);
		return game;
	}
}
