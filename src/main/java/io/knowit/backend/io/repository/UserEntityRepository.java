package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
