package io.knowit.backend.service.impl;

import io.knowit.backend.exception.UserAlreadyExistsException;
import io.knowit.backend.io.model.ApplicationUser;
import io.knowit.backend.io.repository.ApplicationUserRepository;
import io.knowit.backend.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void signUpUser(ApplicationUser user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (applicationUserRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }

        applicationUserRepository.save(user);
    }
}
