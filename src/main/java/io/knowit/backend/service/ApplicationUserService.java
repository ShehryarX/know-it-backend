package io.knowit.backend.service;

import io.knowit.backend.io.entity.User;
import io.knowit.backend.shared.dto.UserDto;

public interface ApplicationUserService {
    void signUpUser(User user) throws Exception;
    UserDto getUserDetails(UserDto userDto) throws Exception;
}
