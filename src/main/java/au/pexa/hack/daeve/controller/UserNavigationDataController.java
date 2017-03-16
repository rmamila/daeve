package au.pexa.hack.daeve.controller;

import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.service.UserNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/log-navigation-data")
public class UserNavigationDataController {

    @Autowired
    private UserNavigationService userNavigationService;


    @RequestMapping(method = RequestMethod.POST)
    public void logNavigationData(UserNavigationData userNavigationData){
        userNavigationService.save(userNavigationData);

    }


}
