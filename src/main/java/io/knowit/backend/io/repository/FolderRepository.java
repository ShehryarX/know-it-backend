package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.FolderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends MongoRepository<FolderEntity, String> {
    List<FolderEntity> findAllByUserEntityId(String id);
    FolderEntity findByIdAndUserEntityId(String id, String userEntityId);
    void deleteByIdAndUserEntityId(String id, String userEntityId);
}
