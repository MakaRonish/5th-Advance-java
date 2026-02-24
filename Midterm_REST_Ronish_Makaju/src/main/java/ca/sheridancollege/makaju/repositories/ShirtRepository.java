package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Shirt;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long> {

}
