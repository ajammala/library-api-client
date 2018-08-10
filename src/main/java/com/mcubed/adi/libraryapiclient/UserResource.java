package com.mcubed.adi.libraryapiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserResource {
    private RestTemplate restTemplate;

    @Autowired
    public UserResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public String getUser() {
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/user", HttpMethod.GET, null, String.class);
        return responseEntity.getBody();
    }
}
