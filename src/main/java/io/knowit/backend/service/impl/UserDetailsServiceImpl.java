package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.User;
import io.knowit.backend.io.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserEntityRepository userEntityRepository;

    public UserDetailsServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameId) throws UsernameNotFoundException {
        Optional<User> userEntity = userEntityRepository.findById(usernameId);
        if (!userEntity.isPresent()) {
            throw new UsernameNotFoundException(usernameId);
        }
        return new org.springframework.security.core.userdetails.User(userEntity.get().getId(), userEntity.get().getPassword(), emptyList());
    }
}
