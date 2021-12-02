package io.knowit.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.knowit.backend.proto.request.content.ContentRequest;
import io.knowit.backend.proto.response.FlashcardResponse;
import io.knowit.backend.security.CurrentUser;
import io.knowit.backend.security.UserPrincipal;
import io.knowit.backend.service.FlashcardService;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.service.impl.GenerateFlashcardRequest;
import io.knowit.backend.shared.dto.FlashcardDto;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public List<FlashcardResponse> getFlashcards(@RequestParam("id") String noteId, @CurrentUser UserPrincipal userPrincipal) throws Exception {
        FlashcardDto flashcardDto = new FlashcardDto();
        flashcardDto.setUserId(userPrincipal.getId());
        flashcardDto.setNoteId(noteId);

        List<FlashcardDto> flashcards = this.flashcardService.getAllFlashcardsForNote(flashcardDto);
        List<FlashcardResponse> response = new ArrayList<>();

        for (FlashcardDto dto : flashcards) {
            FlashcardResponse responseItem = new FlashcardResponse();
            BeanUtils.copyProperties(dto, responseItem);
            response.add(responseItem);
        }

        return response;
    }

    @GetMapping(value = "generate", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public List<FlashcardResponse> generateFlashcards(@RequestParam("id") String noteId, @CurrentUser UserPrincipal userPrincipal) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        NoteDto noteDto = new NoteDto();
        noteDto.setUserId(userPrincipal.getId());
        noteDto.setId(noteId);
        NoteDto note = this.noteService.getNote(noteDto);

        FlashcardDto flashcardDto = new FlashcardDto();
        flashcardDto.setUserId(userPrincipal.getId());
        flashcardDto.setNoteId(noteId);
        flashcardDto.setContents(mapper.readValue(note.getContents(), ContentRequest.class));

        List<FlashcardDto> flashcards = this.flashcardService.generateFlashcards(flashcardDto);
        List<FlashcardResponse> response = new ArrayList<>();

        for (FlashcardDto dto : flashcards) {
            FlashcardResponse responseItem = new FlashcardResponse();
            BeanUtils.copyProperties(dto, responseItem);
            response.add(responseItem);
        }

        return response;
    }

}
