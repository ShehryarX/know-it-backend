package io.knowit.backend.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import io.knowit.backend.io.entity.Flashcard;
import io.knowit.backend.io.repository.FlashcardRepository;
import io.knowit.backend.proto.request.content.ContentBlock;
import io.knowit.backend.proto.request.content.ContentRequest;
import io.knowit.backend.proto.request.content.QuestionAnswerBlock;
import io.knowit.backend.proto.request.content.QuestionAnswerBlockDetail;
import io.knowit.backend.service.FlashcardService;
import io.knowit.backend.shared.dto.FlashcardDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public List<FlashcardDto> getAllFlashcardsForNote(FlashcardDto flashcardDto) {
        List<Flashcard> flashcards = this.flashcardRepository.findAllByUserIdAndNoteId(flashcardDto.getUserId(), flashcardDto.getNoteId());

        List<FlashcardDto> flashcardDtos = new ArrayList<>();

        for (Flashcard flashcard : flashcards) {
            FlashcardDto dto = new FlashcardDto();
            BeanUtils.copyProperties(flashcard, dto);
            flashcardDtos.add(dto);
        }

        return flashcardDtos;
    }

    @Override
    public List<FlashcardDto> generateFlashcards(FlashcardDto flashcardDto) {
        ContentRequest contentRequest = flashcardDto.getContents();
        List<FlashcardDto> flashcards = new ArrayList<>();

        for (ContentBlock block : contentRequest.getBlocks()) {
            if (block instanceof QuestionAnswerBlock) {
                QuestionAnswerBlock qaBlock = (QuestionAnswerBlock) block;
                QuestionAnswerBlockDetail detail = qaBlock.getData();

                if (detail.getQuestion().length() > 0 && detail.getAnswer().length() > 0) {
                    Flashcard flashcard = new Flashcard(detail.getQuestion(), detail.getAnswer(),
                            flashcardDto.getNoteId(), flashcardDto.getUserId());
                    this.flashcardRepository.save(flashcard);

                    FlashcardDto dto = new FlashcardDto();
                    BeanUtils.copyProperties(flashcard, dto);
                    flashcards.add(dto);
                }
            }
        }

        return flashcards;
    }
}
