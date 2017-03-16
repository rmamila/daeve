package au.pexa.hack.daeve.service;

import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.repositories.UserNavigationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNavigationService {

    @Autowired
    private UserNavigationDataRepository userNavigationDataRepository;

    public String save(UserNavigationData userNavigationData){

        userNavigationData = userNavigationDataRepository.save(userNavigationData);
        System.out.println("########################## "   + userNavigationData);
        return userNavigationData.getId();
    }

}
