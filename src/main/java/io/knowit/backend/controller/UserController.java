package io.knowit.backend.controller;

import io.knowit.backend.proto.response.GetUserLoginResponse;
import io.knowit.backend.security.CurrentUser;
import io.knowit.backend.security.UserPrincipal;
import io.knowit.backend.service.UserService;
import io.knowit.backend.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public GetUserLoginResponse getCurrentUser(@CurrentUser UserPrincipal userPrincipal) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(userPrincipal.getId());

        UserDto user = userService.findById(userDto);
        GetUserLoginResponse response = new GetUserLoginResponse();

        BeanUtils.copyProperties(user, response);
        return response;
    }
}
