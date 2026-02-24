package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.makaju.beans.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {

}
