package au.pexa.hack.daeve.receiver;

import java.util.concurrent.TimeUnit;

import au.pexa.hack.daeve.DaeveApplication;
import au.pexa.hack.daeve.model.Suggestion;
import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.service.UserActionSuggestionsService;
import au.pexa.hack.daeve.service.UserNavigationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private UserActionSuggestionsService userActionSuggestionsService;

    @Autowired
    private UserNavigationService userNavigationService;

    @Override
    public void run(String... args) throws Exception {

        UserNavigationData userNavigationData = new UserNavigationData();
        userNavigationData.setSessionId("Blah");
        userNavigationData.setSubscriberType("test");
        userNavigationData.setSubscriberType("Principle");
        userNavigationData.setUsername("chaminda");
        userNavigationService.save(userNavigationData);

        Suggestion suggestion = new Suggestion();
        suggestion.setUsername("chaminda");
        suggestion.setSubscriberType("REp");
        userActionSuggestionsService.saveUserSuggestion(suggestion);

        System.out.println("################ " + userNavigationService.getUserNavigationBy("chaminda"));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$ " + userActionSuggestionsService.getSuggestionsFor("chaminda"));

    }

}