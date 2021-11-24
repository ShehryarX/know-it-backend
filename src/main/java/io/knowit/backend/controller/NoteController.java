package io.knowit.backend.controller;

import io.knowit.backend.proto.request.CreateNoteRequest;
import io.knowit.backend.proto.request.UpdateNoteRequest;
import io.knowit.backend.proto.response.NoteResponse;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public NoteResponse getNote(@RequestParam("id") String noteId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteDto noteDto = new NoteDto();
        noteDto.setId(noteId);

        String userId = auth.getName();
        noteDto.setUserId(userId);

        NoteDto note = this.noteService.getNote(noteDto);

        NoteResponse response = new NoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public NoteResponse createNote(@Valid @RequestBody CreateNoteRequest noteRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(noteRequest, noteDto);

        String userId = auth.getName();
        noteDto.setUserId(userId);

        NoteDto note = this.noteService.createNote(noteDto);

        NoteResponse response = new NoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    public NoteResponse updateNote(@Valid @RequestBody UpdateNoteRequest updatedNote) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(updatedNote, noteDto);
        String userId = auth.getName();
        noteDto.setUserId(userId);

        NoteDto newNote = this.noteService.updateNote(noteDto);

        NoteResponse note = new NoteResponse();
        BeanUtils.copyProperties(newNote, note);

        return note;
    }

    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    public void deleteNote(@RequestParam("id") String noteId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteDto noteDto = new NoteDto();
        noteDto.setId(noteId);

        String userId = auth.getName();
        noteDto.setUserId(userId);

        this.noteService.deleteNote(noteDto);
    }
}
