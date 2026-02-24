package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.makaju.beans.Judge;

public interface JudgeRepository extends JpaRepository<Judge, Long> {

}
