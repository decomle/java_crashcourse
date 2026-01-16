package com.decomle.relearn.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(path = "/")
    public String home(HttpServletRequest request) {
//        request.getSession().
        return "Hello world, I am a test for Spring security. Session ID: " + request.getSession().getId();
    }
}
