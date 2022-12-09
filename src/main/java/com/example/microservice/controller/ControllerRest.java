package com.example.microservice.controller;

//Controlador REST

import com.example.microservice.configuration.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class ControllerRest {

    @Autowired
    private ApplicationConfig appConfig;

    @GetMapping("/controller")
    public String controlador(){

        System.out.println(appConfig.toString());
        return "Servicio Rest Java";
    }
}
