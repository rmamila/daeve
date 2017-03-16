package au.pexa.hack.daeve.controller;

import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.service.UserActionSuggestionsService;
import au.pexa.hack.daeve.service.UserNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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



}
