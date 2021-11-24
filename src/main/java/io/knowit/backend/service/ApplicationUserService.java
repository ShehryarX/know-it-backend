package io.knowit.backend.service;

import io.knowit.backend.io.entity.UserEntity;

public interface ApplicationUserService {
    void signUpUser(UserEntity user) throws Exception;
}
