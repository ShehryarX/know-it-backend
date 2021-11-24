package io.knowit.backend.service.impl;

import io.knowit.backend.exception.UserAlreadyExistsException;
import io.knowit.backend.io.entity.UserEntity;
import io.knowit.backend.io.repository.UserEntityRepository;
import io.knowit.backend.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserServiceImpl(UserEntityRepository userEntityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void signUpUser(UserEntity user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (userEntityRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }

        userEntityRepository.save(user);
    }
}
