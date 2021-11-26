package io.knowit.backend.service;

import io.knowit.backend.io.entity.User;
import io.knowit.backend.shared.dto.UserDto;

public interface UserService {
    void signUpUser(User user) throws Exception;
    UserDto getUserDetails(UserDto userDto) throws Exception;
    UserDto findById(UserDto userDto) throws Exception;
}
