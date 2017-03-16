package au.pexa.hack.daeve.repositories;

import au.pexa.hack.daeve.model.UserNavigationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNavigationDataRepository extends MongoRepository<UserNavigationData, String> {

    UserNavigationData findByUsername();
}


