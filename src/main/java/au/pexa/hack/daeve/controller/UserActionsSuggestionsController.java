package au.pexa.hack.daeve.controller;

import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.service.UserActionSuggestionsService;
import au.pexa.hack.daeve.service.UserNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/suggestions")
public class UserActionsSuggestionsController {

    @Autowired
    private UserActionSuggestionsService userActionSuggestionsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK)
    public Suggestion getSuggestionFor(@RequestParam String username){
        return userActionSuggestionsService.getSuggestionsFor(username);
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED)
    public void logNavigationData(@RequestBody Suggestion suggestion){
        userActionSuggestionsService.saveUserSuggestion(suggestion);
    }



}
