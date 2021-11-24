package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.NoteEntity;
import io.knowit.backend.io.repository.NoteRepository;
import io.knowit.backend.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteEntity updateNote(NoteEntity updatedNote) {
        NoteEntity note = this.noteRepository.findByIdAndUserEntityId(updatedNote.getId(), updatedNote.getUserEntityId());

        note.setTitle(updatedNote.getTitle());
        note.setContents(updatedNote.getContents());

        this.noteRepository.save(note);
        return note;
    }

    @Override
    public NoteEntity createNote(NoteEntity newNote) {
        this.noteRepository.save(newNote);
        return newNote;
    }

    @Override
    public NoteEntity getNote(NoteEntity note) {
        return this.noteRepository.findByIdAndUserEntityId(note.getId(), note.getUserEntityId());
    }

    @Override
    public List<NoteEntity> getNotesInFolder(NoteEntity note) {
        return this.noteRepository.findAllByFolderEntityIdAndUserEntityId(note.getFolderEntityId(), note.getUserEntityId());
    }

    @Override
    public void deleteNote(NoteEntity noteEntity) {
        this.noteRepository.deleteNoteEntityByIdAndUserEntityId(noteEntity.getId(), noteEntity.getUserEntityId());
    }
}
