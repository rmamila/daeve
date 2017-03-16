package au.pexa.hack.daeve.receiver;

import java.util.concurrent.CountDownLatch;

import au.pexa.hack.daeve.service.UserNavigationService;
import au.pexa.hack.daeve.model.UserNavigationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private UserNavigationService userNavigationService;

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");

//        UserNavigationData userNavigationData = new UserNavigationData();
//        userNavigationData.setSessionId("Blah");
//        userNavigationData.setSubscriberType("test");
//        userNavigationService.save(userNavigationData);

        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
