package io.knowit.backend.controller;

import io.knowit.backend.proto.SignUpUserRequest;
import io.knowit.backend.io.entity.UserEntity;
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
    private ApplicationUserService applicationUserService;

    public UserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping(value = "/sign-up", consumes = "application/json", produces = "application/json")
    public void signUp(@Valid @RequestBody SignUpUserRequest user) throws Exception {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setUsername(user.getEmail());
        this.applicationUserService.signUpUser(userEntity);
    }
}
