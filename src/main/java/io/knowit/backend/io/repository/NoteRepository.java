package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    Note findByIdAndUserIdAndIsInTrash(String id, String userId, Boolean inTrash);
    List<Note> findAllByFolderIdAndUserIdAndIsInTrash(String folderId, String userId, Boolean inTrash);
    List<Note> findAllByIsInTrash(Boolean inTrash);
}
