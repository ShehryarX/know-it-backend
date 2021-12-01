package io.knowit.backend.service;

import io.knowit.backend.shared.dto.NoteDto;

import java.util.List;

public interface NoteService {
    NoteDto getNote(NoteDto note);
    List<NoteDto> getNotesInFolder(NoteDto note);
    List<NoteDto> getNotesInTrash(NoteDto note);
    NoteDto createNote(NoteDto newNote);
    NoteDto updateNote(NoteDto updatedNote);
    void deleteNote(NoteDto note);
    NoteDto recoverNote(NoteDto note);
    NoteDto updateNoteTitle(NoteDto noteDto);
    void deleteAllNotesInTrash(NoteDto noteDto);
}
