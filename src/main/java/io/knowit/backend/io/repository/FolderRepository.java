package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.UserEntity;
import io.knowit.backend.io.entity.FolderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends MongoRepository<FolderEntity, String> {
    FolderEntity findByUserEntity(UserEntity user);
}
