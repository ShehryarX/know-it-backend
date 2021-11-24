package io.knowit.backend.controller;

import io.knowit.backend.io.model.ApplicationUser;
import io.knowit.backend.io.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @GetMapping("/test")
    public String test() {
//        applicationUserRepository.save(new ApplicationUser("Shehryar", "Assad"));
        return "Hello, world!";
    }

    @GetMapping("/test-return")
    public List<ApplicationUser> testReturn() {
        return applicationUserRepository.findAll();
    }
}
