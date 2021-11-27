package io.knowit.backend.controller;

import io.knowit.backend.exception.BodyValidationException;
import io.knowit.backend.proto.request.CreateNoteRequest;
import io.knowit.backend.proto.request.UpdateNoteRequest;
import io.knowit.backend.proto.response.BriefNoteDescriptionResponse;
import io.knowit.backend.proto.response.NoteResponse;
import io.knowit.backend.security.CurrentUser;
import io.knowit.backend.security.UserPrincipal;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public NoteResponse getNote(@RequestParam("id") String noteId, @CurrentUser UserPrincipal userPrincipal) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(noteId);
        noteDto.setUserId(userPrincipal.getId());

        NoteDto note = this.noteService.getNote(noteDto);
        NoteResponse response = new NoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @GetMapping(value = "/in-trash", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public List<BriefNoteDescriptionResponse> getNotesInTrash() {
        List<NoteDto> notesInTrash = this.noteService.getNotesInTrash();
        List<BriefNoteDescriptionResponse> response = new ArrayList<>();

        for (NoteDto noteDto : notesInTrash) {
            BriefNoteDescriptionResponse responseNote = new BriefNoteDescriptionResponse();
            BeanUtils.copyProperties(noteDto, responseNote);
            response.add(responseNote);
        }

        return response;
    }

    @DeleteMapping(value = "/recover-note", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public NoteResponse recoverNote(@RequestParam("id") String noteId, @CurrentUser UserPrincipal userPrincipal) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(noteId);
        noteDto.setUserId(userPrincipal.getId());

        NoteDto recoveredNote = this.noteService.recoverNote(noteDto);

        NoteResponse response = new NoteResponse();
        BeanUtils.copyProperties(recoveredNote, response);

        return response;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public NoteResponse createNote(@Valid @RequestBody CreateNoteRequest noteRequest, Errors errors,
                                   @CurrentUser UserPrincipal userPrincipal) throws BodyValidationException {
        if (errors.hasErrors()) {
            throw new BodyValidationException(errors);
        }

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(noteRequest, noteDto);
        noteDto.setUserId(userPrincipal.getId());
        NoteDto note = this.noteService.createNote(noteDto);

        NoteResponse response = new NoteResponse();
        BeanUtils.copyProperties(note, response);

        return response;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public NoteResponse updateNote(@Valid @RequestBody UpdateNoteRequest updatedNote, Errors errors,
                                   @CurrentUser UserPrincipal userPrincipal) throws BodyValidationException {
        if (errors.hasErrors()) {
            throw new BodyValidationException(errors);
        }

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(updatedNote, noteDto);
        noteDto.setUserId(userPrincipal.getId());
        NoteDto newNote = this.noteService.updateNote(noteDto);

        NoteResponse note = new NoteResponse();
        BeanUtils.copyProperties(newNote, note);

        return note;
    }

    @PutMapping(value = "/title", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public NoteResponse updateTitle(@Valid @RequestBody UpdateNoteRequest updatedNote, Errors errors,
                                   @CurrentUser UserPrincipal userPrincipal) throws BodyValidationException {
        if (errors.hasErrors()) {
            throw new BodyValidationException(errors);
        }

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(updatedNote, noteDto);
        noteDto.setUserId(userPrincipal.getId());

        NoteDto newNote = this.noteService.updateNoteTitle(noteDto);
        NoteResponse note = new NoteResponse();
        BeanUtils.copyProperties(newNote, note);

        return note;
    }



    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public void deleteNote(@RequestParam("id") String noteId, @CurrentUser UserPrincipal userPrincipal) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(noteId);
        noteDto.setUserId(userPrincipal.getId());
        this.noteService.deleteNote(noteDto);
    }
}
