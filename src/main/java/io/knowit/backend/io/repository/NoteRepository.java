package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    void deleteNoteByIdAndUserId(String id, String userId);
    Note findByIdAndUserId(String id, String userId);
    List<Note> findAllByFolderIdAndUserId(String folderId, String userId);
}
