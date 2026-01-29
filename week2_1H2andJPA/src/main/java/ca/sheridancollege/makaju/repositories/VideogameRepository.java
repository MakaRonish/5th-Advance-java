package ca.sheridancollege.makaju.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Videogame;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long>{
	
	public List<Videogame> findByTitleContainingIgnoreCase(String title);
	public List<Videogame> findByGenre(String genre);
	public List<Videogame> findByPriceLessThan(double price);
	 
	
	public List<Videogame> findBy(Pageable page);

}