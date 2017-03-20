package au.pexa.hack.daeve.service;


import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.repositories.UserActionSuggestionsRepository;
import au.pexa.hack.daeve.util.SuggestNextAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserActionSuggestionsService {

    @Autowired
    private UserActionSuggestionsRepository userActionSuggestionsRepository;

    @Autowired
    private UserNavigationService userNavigationService;

    @Autowired
    private SuggestNextAction suggestNextAction;

    public String saveUserSuggestion(final Suggestion suggestion){
        return userActionSuggestionsRepository.save(suggestion).getId();
    }

    public Suggestion getSuggestionsFor(final String username) {

        final Suggestion suggestion = new Suggestion();
        List<UserNavigationData> userNavigationData = (List<UserNavigationData>) userNavigationService.getUserNavigationBy(username);
        sortData(userNavigationData);

        if(!userNavigationData.isEmpty()) {
            suggestion.setLastAccessedPage(getLastAccessedPage(userNavigationData));
            suggestion.setLastAccessedSystem(getLastAccessedSystem(userNavigationData));
            Map<String, Integer> goals = suggestNextAction.getUserGoals(userNavigationData);
            suggestion.setGoal(goals);
        }
        suggestion.setNewUser(userNavigationData.isEmpty());

        return suggestion;
    }

    protected List<UserNavigationData> sortData(List<UserNavigationData> userNavigationData){

        Collections.sort(userNavigationData, (navDataOne, navDataTwo) -> navDataOne.getTimestamp().compareTo(navDataTwo.getTimestamp()));
        return userNavigationData;
    }

    private boolean isNewUser(Collection<UserNavigationData> userNavigationData ){
        return false;
    }

    public HashMap<String, Integer> getUserGoal(Collection<UserNavigationData> userNavigationData ){
        return null;

    }

    protected String getLastAccessedPage(List<UserNavigationData> userNavigationData){
        Optional<UserNavigationData> last = userNavigationData.stream().reduce((f, s) -> s);
        if(last.isPresent()){
            final UserNavigationData lastNavigation = last.get();
            final String urlPattern = lastNavigation.getUrlPattern();
            System.out.println("urlPattern = " + urlPattern);
            return getLastAccessedPage(urlPattern);

        }
        return null;
    }

    protected String getLastAccessedSystem(List<UserNavigationData> userNavigationData){
        Optional<UserNavigationData> last = userNavigationData.stream().reduce((f, s) -> s);
        if(last.isPresent()){
            final UserNavigationData lastNavigation = last.get();
            final String urlPattern = lastNavigation.getUrlPattern();
            return getLastAccessedSystem(urlPattern);

        }
        return null;
    }



    protected String getLastAccessedPage(String url){
        int start = url.lastIndexOf("/");
        int end = url.indexOf("?") != 0 ? url.indexOf("?")  : url.length()-1;
        return url.substring(start+1, end);

    }

    protected String getLastAccessedSystem(String url){
        int start = url.indexOf("/") +1;
        String second = url.substring(start);
        int end = second.indexOf("/");
        return url.substring(start ,end +1);

    }



}
