package com.example.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeOtherComponent {

    @Autowired
    private ResponseGenerator responseGenerator;

    public void someMethod() {
        responseGenerator.setInput("Some input value");
        responseGenerator.generateResponse();
        // ...
    }
}
