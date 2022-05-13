package com.example.HospitalV2doctorservice.controller;

import com.example.HospitalV2doctorservice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    Environment environment;

    @GetMapping("/list/v1/{userId}")
    public String getCardList(@PathVariable String userId){
        return "card list" + userId + "service port: " + environment.getProperty("local.server.port");

    }
}
