package ca.sheridancollege.makaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>  {

}
