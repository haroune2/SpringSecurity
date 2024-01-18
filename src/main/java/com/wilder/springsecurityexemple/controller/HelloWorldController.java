package com.wilder.springsecurityexemple.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 
@CrossOrigin (origins ="https://automatic-space-guide-j66qw6qw5x9fp5xp-8080.app.github.dev")
public class HelloWorldController {
    @GetMapping("/")
    public String hello() {
        return "Hello World!!!";
    }
}
