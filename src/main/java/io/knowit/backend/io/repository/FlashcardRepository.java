package io.knowit.backend.io.repository;

import io.knowit.backend.io.entity.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlashcardRepository extends MongoRepository<Flashcard, String> {
    public List<Flashcard> findAllByUserIdAndNoteId(String userId, String noteId);
}
