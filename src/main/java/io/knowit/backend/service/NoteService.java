package io.knowit.backend.service;

import io.knowit.backend.io.entity.NoteEntity;

import java.util.List;

public interface NoteService {
    void deleteNote(NoteEntity noteEntity);
    NoteEntity updateNote(NoteEntity updatedNote);
    NoteEntity createNote(NoteEntity newNote);
    NoteEntity getNote(NoteEntity note);
    List<NoteEntity> getNotesInFolder(NoteEntity note);
}
