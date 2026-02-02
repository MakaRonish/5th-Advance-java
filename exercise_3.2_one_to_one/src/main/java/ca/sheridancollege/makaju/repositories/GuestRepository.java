package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

}
