package au.pexa.hack.daeve.controller;

import au.pexa.hack.daeve.DaeveApplication;
import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("ci")
public abstract class AbstractIntegrationTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void beforeEachTest() {
        RestAssured.port = serverPort;
        doBeforeEachTest();

    }

    @After
    public void afterEachTest(){
        doAfterEachTest();

    }


    protected void doBeforeEachTest() {

    }

    protected void doAfterEachTest(){

    }

}