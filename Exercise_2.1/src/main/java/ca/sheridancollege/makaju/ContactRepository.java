package ca.sheridancollege.makaju;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.contacts;

@Repository
public interface ContactRepository extends
JpaRepository<contacts, Integer> {

}
