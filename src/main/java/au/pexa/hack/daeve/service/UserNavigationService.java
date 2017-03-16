package au.pexa.hack.daeve.service;

import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.repositories.UserNavigationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserNavigationService {

    @Autowired
    private UserNavigationDataRepository userNavigationDataRepository;

    public String save(UserNavigationData userNavigationData){
        return userNavigationDataRepository.save(userNavigationData).getId();
    }

    public Collection<UserNavigationData> getUserNavigationBy(final String username){
        return userNavigationDataRepository.findByUsername(username);
    }

}
