package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.Folder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String> {
    List<Folder> findAllByUserId(String id);
    Folder findByIdAndUserId(String id, String userId);
    void deleteByIdAndUserId(String id, String userId);
}
