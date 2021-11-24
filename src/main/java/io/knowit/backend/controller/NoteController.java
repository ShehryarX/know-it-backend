package io.knowit.backend.controller;

import io.knowit.backend.io.entity.NoteEntity;
import io.knowit.backend.proto.*;
import io.knowit.backend.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public GetNoteResponse getNote(@RequestParam("id") String noteId) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(noteId);

        String userId = auth.getName();
        noteEntity.setUserEntityId(userId);

        NoteEntity note = this.noteService.getNote(noteEntity);

        GetNoteResponse response = new GetNoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public CreateNoteResponse createNote(@Valid @RequestBody CreateNoteRequest noteRequest) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setTitle(noteRequest.getTitle());
        noteEntity.setFolderEntityId(noteRequest.getFolderEntityId());
        noteEntity.setContents("");
        noteEntity.setTimeUpdated(new Date());

        String userId = auth.getName();
        noteEntity.setUserEntityId(userId);

        NoteEntity note = this.noteService.createNote(noteEntity);

        CreateNoteResponse response = new CreateNoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    public UpdateNoteResponse updateNote(@Valid @RequestBody UpdateNoteRequest updatedNote) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(updatedNote.getId());
        noteEntity.setTitle(updatedNote.getTitle());
        noteEntity.setContents(updatedNote.getContents());

        String userId = auth.getName();
        noteEntity.setUserEntityId(userId);

        NoteEntity newNote = this.noteService.updateNote(noteEntity);

        UpdateNoteResponse note = new UpdateNoteResponse();
        BeanUtils.copyProperties(newNote, note);

        return note;
    }

    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    public void deleteNote(@RequestParam("id") String noteId) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(noteId);

        String userId = auth.getName();
        noteEntity.setUserEntityId(userId);

        this.noteService.deleteNote(noteEntity);
    }
}
