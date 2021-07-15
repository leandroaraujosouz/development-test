package com.fivesoftware.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivesoftware.ecommerce.model.MoviesModel;
import com.fivesoftware.ecommerce.repository.MoviesRepository;



@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MoviesController {
	
	@Autowired
	private MoviesRepository repository;
	
	@GetMapping
	public ResponseEntity<List<MoviesModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MoviesModel> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{title}")
	public ResponseEntity<List<MoviesModel>> GetByTitle(@PathVariable String title){
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
	}
	
	@GetMapping("/genero/{genres}")
	public ResponseEntity<List<MoviesModel>> GetByGenres(@PathVariable String genres){
		return ResponseEntity.ok(repository.findAllByGenresContainingIgnoreCase(genres));
	}
	
	@PostMapping
	public ResponseEntity<MoviesModel> post (@RequestBody MoviesModel MoviesModel){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(MoviesModel));
	}
	
	@PutMapping
	public ResponseEntity<MoviesModel> put (@RequestBody MoviesModel MoviesModel){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(MoviesModel));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
