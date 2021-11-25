package io.knowit.backend.controller;

import io.knowit.backend.proto.request.SignUpUserRequest;
import io.knowit.backend.io.entity.UserEntity;
import io.knowit.backend.proto.response.GetUserDetailsResponse;
import io.knowit.backend.service.ApplicationUserService;
import io.knowit.backend.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
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

    @GetMapping(value = "/detail", consumes = "application/json", produces = "application/json")
    public GetUserDetailsResponse getUserData() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDto userDto = new UserDto();
        String userId = auth.getName();
        userDto.setId(userId);

        UserDto userDetails = applicationUserService.getUserDetails(userDto);

        GetUserDetailsResponse response = new GetUserDetailsResponse();
        BeanUtils.copyProperties(userDetails, response);

        return response;
    }
}
