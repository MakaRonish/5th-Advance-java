package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.makaju.beans.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
