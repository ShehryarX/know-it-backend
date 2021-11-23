package io.knowit.backend.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AppController {
    @GetMapping("/test")
    public String test() {
        return "Hello, world!";
    }
}
