package au.pexa.hack.daeve.controller;

import au.pexa.hack.daeve.model.UserNavigationData;
import au.pexa.hack.daeve.service.UserNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("api/log-navigation-data")
public class UserNavigationDataController {

    @Autowired
    private UserNavigationService userNavigationService;


    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED)
    public void logNavigationData(@RequestBody UserNavigationData userNavigationData){
        userNavigationService.save(userNavigationData);
    }


}
