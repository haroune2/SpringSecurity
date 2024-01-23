package com.wilder.springsecurityexemple.controller;

import java.util.Arrays;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the SHIELD";
    }

    @GetMapping("/avengers/assemble")
    public String assemble() {
        return "Avengers... Assemble";

    }

    @GetMapping("/secret-bases")
    public String secretBases() {
        // https://wildcodeschool.fr/nos-campus/ >> Connection timed out Error code 522
        // , le 18/01/2014
        return "la liste de toutes les villes où il y a une Wild Code School: "+Arrays.asList("Bordeaux", "Lyon", "Nantes", "Lille", "Paris", "Toulouse").toString();

    }

}
