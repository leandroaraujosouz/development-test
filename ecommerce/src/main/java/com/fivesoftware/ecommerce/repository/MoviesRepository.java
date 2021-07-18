package com.fivesoftware.ecommerce.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivesoftware.ecommerce.model.MoviesModel;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {
	
	public Page<MoviesModel> findAllByTitleContainingIgnoreCase (Pageable page, String title); 
	
	public Page<MoviesModel> findAllByGenresContainingIgnoreCase (Pageable page, String genres); 

}
