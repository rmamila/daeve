package au.pexa.hack.daeve.repositories;

import au.pexa.hack.daeve.model.UserNavigationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserNavigationDataRepository extends MongoRepository<UserNavigationData, String> {

    Collection<UserNavigationData> findByUsername(String username);
}


