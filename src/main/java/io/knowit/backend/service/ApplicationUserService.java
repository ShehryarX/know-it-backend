package io.knowit.backend.service;

import io.knowit.backend.io.entity.UserEntity;
import io.knowit.backend.shared.dto.UserDto;

public interface ApplicationUserService {
    void signUpUser(UserEntity user) throws Exception;
    UserDto getUserDetails(UserDto userDto) throws Exception;
}
