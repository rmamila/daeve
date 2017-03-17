package au.pexa.hack.daeve.controller;


import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.service.UserActionSuggestionsService;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.IsNull.notNullValue;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.given;

public class UserActionSuggestionsControllerIT extends AbstractIntegrationTest{

    @Autowired
    private UserActionSuggestionsService   userActionSuggestionsService;

    private static final String SOME_USER = "user@user.com";

    @Test
    public void shouldSaveUserNavigationData(){
        //given
        final Suggestion suggestion = getSuggestionsFor(SOME_USER);

        //and
        given().
                body(suggestion).
                contentType(ContentType.JSON).
                when().
                post("/api/suggestions").
                then().
                statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void shouldGetUserActionSuggestionForGivenUsername(){
        //given
        userActionSuggestionsService.saveUserSuggestion(getSuggestionsFor(SOME_USER));

        //and
         given().
         when().
                get("/api/suggestions?username="+SOME_USER).
         then().
                statusCode(HttpStatus.SC_OK)
                .body("id", notNullValue())
                .body("username", IsEqual.equalTo(SOME_USER));
    }



    private Suggestion getSuggestionsFor(String username){
        final Suggestion suggestion = new Suggestion();
        suggestion.setUsername(username);
        suggestion.setSubscriberType("Representative");
        suggestion.setLastAccessedPage("http://localhost/blah");
        suggestion.setSubscriberId("208");
        return suggestion;
    }

}
