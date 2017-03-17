package au.pexa.hack.daeve.service;


import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.repositories.UserActionSuggestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

@Component
public class UserActionSuggestionsService {

    @Autowired
    private UserActionSuggestionsRepository userActionSuggestionsRepository;

    @Autowired
    private UserNavigationService userNavigationService;

    public String saveUserSuggestion(final Suggestion suggestion){
        return userActionSuggestionsRepository.save(suggestion).getId();
    }

    public Suggestion getSuggestionsFor(final String username) {
        Collection<UserNavigationData> userNavigationData = userNavigationService.getUserNavigationBy(username);
//        Collections.sort(userNavigationData, (navDataOne, navDataTwo) -> navDataOne.getTimestamp().compareTo(navDataTwo.getTimestamp()));


        return userActionSuggestionsRepository.findByUsername(username);
    }

    private boolean isNewUser(Collection<UserNavigationData> userNavigationData ){
        return false;
    }

    public HashMap<String, Integer> getUserGoal(Collection<UserNavigationData> userNavigationData ){
        return null;

    }

    private String getLastAccessedPage(){
        return null;
    }

    private String getLastAccessedSystem(){
        return null;
    }



}
