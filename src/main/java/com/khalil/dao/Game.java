package com.khalil.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private Long id;
	private String title;

	@OneToOne
	private Platform platform;
	private float score;
	
	@ManyToMany
	private List<Genre> genre;
	
	@OneToOne
	private EditorsChoice editorsChoice;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}


	public EditorsChoice getEditorsChoice() {
		return editorsChoice;
	}

	public void setEditorsChoice(EditorsChoice editorsChoice) {
		this.editorsChoice = editorsChoice;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
