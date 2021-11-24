package io.knowit.backend.controller;

import io.knowit.backend.proto.SignUpUserRequest;
import io.knowit.backend.io.model.ApplicationUser;
import io.knowit.backend.service.ApplicationUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ApplicationUserService applicationUserService;

    public UserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping(value = "/sign-up", consumes = "application/json", produces = "application/json")
    public void signUp(@Valid @RequestBody SignUpUserRequest user) throws Exception {
        ApplicationUser applicationUser = new ApplicationUser();
        BeanUtils.copyProperties(user, applicationUser);
        this.applicationUserService.signUpUser(applicationUser);
    }
}
