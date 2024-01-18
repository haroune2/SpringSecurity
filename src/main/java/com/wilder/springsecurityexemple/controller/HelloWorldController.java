package com.wilder.springsecurityexemple.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

 public class HelloWorldController {
    @GetMapping("/")
    public String hello() {
        return "Hello World!!!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!!!";
    }
}
