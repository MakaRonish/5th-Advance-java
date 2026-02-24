package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Therapist;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {

}
