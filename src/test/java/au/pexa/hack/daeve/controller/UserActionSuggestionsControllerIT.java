package au.pexa.hack.daeve.controller;


import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class UserActionSuggestionsControllerIT extends AbstractIntegrationTest{

    @Test
    public void shouldGetUserActionSuggestionForGivenUsername(){
        //given
        final String username = "user@user.com";

        //and

        given().
         when().
                get("/api/suggestions?username="+username).
         then().
                statusCode(HttpStatus.SC_OK);
    }
}
