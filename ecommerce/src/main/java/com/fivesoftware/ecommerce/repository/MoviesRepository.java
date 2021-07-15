package com.fivesoftware.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivesoftware.ecommerce.model.MoviesModel;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {
	
	public List<MoviesModel> findAllByTitleContainingIgnoreCase (String title); 
	
	public List<MoviesModel> findAllByGenresContainingIgnoreCase (String genres); 

}
