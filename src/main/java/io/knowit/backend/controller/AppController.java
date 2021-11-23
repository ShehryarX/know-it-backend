package io.knowit.backend.controller;

import io.knowit.backend.model.User;
import io.knowit.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        userRepository.save(new User("Shehryar", "Assad"));
        return "Hello, world!";
    }

    @GetMapping("/test-return")
    public List<User> testReturn() {
        return userRepository.findAll();
    }
}
