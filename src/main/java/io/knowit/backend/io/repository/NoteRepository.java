package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.NoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<NoteEntity, String> {
    void deleteNoteEntityByIdAndUserEntityId(String id, String userEntityId);
    NoteEntity findByIdAndUserEntityId(String id, String userEntityId);
    List<NoteEntity> findAllByFolderEntityIdAndUserEntityId(String folderId, String userEntityId);
}
