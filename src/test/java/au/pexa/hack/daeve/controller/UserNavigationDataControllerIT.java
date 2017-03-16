package au.pexa.hack.daeve.controller;


import au.pexa.hack.daeve.model.UserNavigationData;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static org.hamcrest.core.IsNull.notNullValue;
import static com.jayway.restassured.RestAssured.given;

public class UserNavigationDataControllerIT extends AbstractIntegrationTest{

    @Test
    public void shouldSaveUserNavigationData(){

        UserNavigationData userNavigationData = new UserNavigationData();
        userNavigationData.setSessionId("Blah");
        userNavigationData.setSubscriberType("test");



        given().
                body(userNavigationData).
                contentType(ContentType.JSON).
                when().
                post("/api/log-navigation-data").
                then().
                statusCode(HttpStatus.SC_CREATED).
                body("id", notNullValue());

    }
}
