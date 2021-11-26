package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String username);
    Boolean existsByEmail(String email);
}
