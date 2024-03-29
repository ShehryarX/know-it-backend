package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.Folder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String> {
    List<Folder> findAllByUserIdAndIsInTrash(String id, Boolean isInTrash);
    Optional<Folder> findByIdAndUserIdAndIsInTrash(String id, String userId, Boolean isInTrash);
}
