package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Videogame;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long>{
	
	

}