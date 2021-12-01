package io.knowit.backend.service;

import io.knowit.backend.shared.dto.FlashcardDto;

import java.util.List;

public interface FlashcardService {
    List<FlashcardDto> getAllFlashcardsForNote(FlashcardDto flashcardDto);
    List<FlashcardDto> generateFlashcards(FlashcardDto flashcardDto);
}
