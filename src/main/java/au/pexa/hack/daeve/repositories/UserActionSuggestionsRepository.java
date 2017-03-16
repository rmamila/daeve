package au.pexa.hack.daeve.repositories;


import au.pexa.hack.daeve.model.Suggestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionSuggestionsRepository extends MongoRepository<Suggestion, String>{

    public Suggestion findByUsername(String username);

}
