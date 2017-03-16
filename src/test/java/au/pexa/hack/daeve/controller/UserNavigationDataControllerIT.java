package au.pexa.hack.daeve.controller;


import au.pexa.hack.daeve.model.UserNavigationData;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.core.IsNull.notNullValue;
import static com.jayway.restassured.RestAssured.given;

public class UserNavigationDataControllerIT extends AbstractIntegrationTest{

    @Test
    public void shouldSaveUserNavigationData(){
        //given
        final UserNavigationData userNavigationData = getUserNavigationData();

        //and

        given().
                body(userNavigationData).
                contentType(ContentType.JSON).
        when().
                post("api/log-navigation-data").
        then().
                statusCode(HttpStatus.SC_CREATED);
    }

    private UserNavigationData getUserNavigationData() {
        UserNavigationData userNavigationData = new UserNavigationData();
        userNavigationData.setSessionId("my-session-id");
        userNavigationData.setSubscriberType("Representative");
        userNavigationData.setUsername("user@user.com");
        userNavigationData.setUrlPattern("http//localhost:8080/test/data");
        userNavigationData.setWorkspaceId("PEX12345");
        userNavigationData.setTimestamp(LocalDateTime.now());
        return userNavigationData;
    }
}
