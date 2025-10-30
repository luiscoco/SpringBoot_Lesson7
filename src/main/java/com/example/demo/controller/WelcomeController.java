package com.example.demo.controller;

import com.example.demo.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final AppProperties appProperties;

    public WelcomeController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return appProperties.getWelcomeMessage();
    }
}

