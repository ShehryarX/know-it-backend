package io.knowit.backend.service;

import io.knowit.backend.io.model.ApplicationUser;

public interface ApplicationUserService {
    void signUpUser(ApplicationUser user) throws Exception;
}
