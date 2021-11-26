package io.knowit.backend.controller;

import io.knowit.backend.exception.ResourceNotFoundException;
import io.knowit.backend.io.repository.UserEntityRepository;
import io.knowit.backend.io.entity.User;
import io.knowit.backend.security.CurrentUser;
import io.knowit.backend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    // TODO: Use the User Service, not REPOSITORY!
    @Autowired
    private UserEntityRepository userRepository;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
