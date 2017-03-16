package au.pexa.hack.daeve.service;


import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.repositories.UserActionSuggestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserActionSuggestionsService {

    @Autowired
    private UserActionSuggestionsRepository userActionSuggestionsRepository;

    public String saveUserSuggestion(final Suggestion suggestion){
        return userActionSuggestionsRepository.save(suggestion).getId();
    }

    public Suggestion getSuggestionsFor(final String username) {
        // TODO implement this
        Suggestion suggestion = new Suggestion();
        suggestion.setUsername("Chaminda");
        return suggestion;
    }

}
