package io.knowit.backend.service.impl;

import io.knowit.backend.exception.UserAlreadyExistsException;
import io.knowit.backend.io.entity.User;
import io.knowit.backend.io.repository.UserEntityRepository;
import io.knowit.backend.service.ApplicationUserService;
import io.knowit.backend.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void signUpUser(User user) throws UserAlreadyExistsException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (userEntityRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("Username already exists.");
        }

        userEntityRepository.save(user);
    }

    @Override
    public UserDto getUserDetails(UserDto userDto) throws Exception {
        Optional<User> user = userEntityRepository.findById(userDto.getId());

        if (!user.isPresent()) {
            throw new Exception("User ID not found.");
        }

        BeanUtils.copyProperties(user.get(), userDto);
        return userDto;
    }
}
