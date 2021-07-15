package com.fivesoftware.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Movies")
public class MoviesModel {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String title;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String genres;

	public MoviesModel() {
		
	}
	public MoviesModel(@Size(min = 2, max = 255) String title, @Size(min = 2, max = 255) String genres) {
		super();
		this.title = title;
		this.genres = genres;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}	
	
	
}
