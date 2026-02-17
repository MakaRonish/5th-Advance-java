package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.makaju.beans.Player;

public interface PlayerRepository extends JpaRepository<Player,Long> {

}
