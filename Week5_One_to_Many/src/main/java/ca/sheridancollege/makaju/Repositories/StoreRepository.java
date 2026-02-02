package ca.sheridancollege.makaju.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
