package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.Note;
import io.knowit.backend.io.repository.NoteRepository;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserId(noteDto.getId(), noteDto.getUserId());

        note.setTitle(noteDto.getTitle());
        note.setContents(noteDto.getContents());
        note.setTimeUpdated(new Date());
        this.noteRepository.save(note);
        BeanUtils.copyProperties(note, noteDto);

        return noteDto;
    }

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note newNote = new Note();

        BeanUtils.copyProperties(noteDto, newNote);
        newNote.setTimeUpdated(new Date());
        newNote.setContents("");
        this.noteRepository.save(newNote);
        BeanUtils.copyProperties(newNote, noteDto);

        return noteDto;
    }

    @Override
    public NoteDto getNote(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserId(noteDto.getId(), noteDto.getUserId());
        BeanUtils.copyProperties(note, noteDto);
        return noteDto;
    }

    @Override
    public List<NoteDto> getNotesInFolder(NoteDto noteDto) {
        List<Note> notes = this.noteRepository.findAllByFolderIdAndUserId(noteDto.getFolderId(), noteDto.getUserId());
        List<NoteDto> noteDtos = new ArrayList<>();

        for (Note note : notes) {
            NoteDto currentNoteDto = new NoteDto();
            BeanUtils.copyProperties(note, currentNoteDto);
            noteDtos.add(currentNoteDto);
        }

        return noteDtos;
    }

    @Override
    public void deleteNote(NoteDto noteDto) {
        this.noteRepository.deleteNoteByIdAndUserId(noteDto.getId(), noteDto.getUserId());
    }
}
