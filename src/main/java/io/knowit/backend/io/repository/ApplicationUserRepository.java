package io.knowit.backend.io.repository;

import io.knowit.backend.io.model.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
    ApplicationUser findByUsername(String username);
}
