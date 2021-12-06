package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.Flashcard;
import io.knowit.backend.proto.request.content.ContentBlock;
import io.knowit.backend.proto.request.content.ParagraphBlock;
import io.knowit.backend.proto.request.content.QuestionAnswerBlock;
import io.knowit.backend.shared.dto.FlashcardDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class GPTFlashcardServiceImpl extends FlashcardServiceImpl {

    private final GPTService service;

    public GPTFlashcardServiceImpl(@Autowired GPTService service) {
        this.service = service;
    }

    @Override
    public List<FlashcardDto> generateFlashcards(FlashcardDto flashcardDto) {
        List<ContentBlock> blocks = flashcardDto.getContents().getBlocks();
        List<FlashcardDto> flashcards = new ArrayList<>();

        // Generate flashcards for each block, with response length variable to contents length
        blocks.parallelStream().forEach(block -> {
            if(block instanceof QuestionAnswerBlock) {
                // Just map questions and answers as cards; use parent impl
                FlashcardDto flashcard = generateForQABlock(flashcardDto, (QuestionAnswerBlock) block);
                if (flashcard != null) {
                    flashcards.add(flashcard);
                }
            } else if(block instanceof ParagraphBlock) {
                ParagraphBlock.ParagraphBlockDetail detail = ((ParagraphBlock) block).getData();
                // Use this as our content to generate flashcards using GPT
                List<String> results = service.questions(detail.getText());
                List<String> answers = results.parallelStream().map(q ->
                        service.answer(detail.getText(), q)
                ).collect(Collectors.toList());

                for (int i = 0; i < results.size(); i++) {
                    String result = results.get(i);
                    String answer = answers.get(i);

                    Flashcard flashcard = new Flashcard(result, answer,
                            flashcardDto.getNoteId(), flashcardDto.getUserId());
                    this.flashcardRepository.save(flashcard);
                    FlashcardDto dto = new FlashcardDto();
                    BeanUtils.copyProperties(flashcard, dto);
                    flashcards.add(dto);
                }

            }
            // Nothing to generate
        });

        return flashcards;
    }

}
