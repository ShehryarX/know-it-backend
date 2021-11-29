package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.Folder;
import io.knowit.backend.io.entity.Note;
import io.knowit.backend.io.repository.FolderRepository;
import io.knowit.backend.io.repository.NoteRepository;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserIdAndIsInTrash(noteDto.getId(), noteDto.getUserId(), false);

        if (noteDto.getTitle() != null) {
            note.setTitle(noteDto.getTitle());
        }

        if (noteDto.getContents() != null) {
            note.setContents(noteDto.getContents());
        }

        if (noteDto.getTimeUpdated() != null) {
            note.setTimeUpdated(new Date());
        }

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
        Note note = this.noteRepository.findByIdAndUserIdAndIsInTrash(noteDto.getId(), noteDto.getUserId(), false);
        BeanUtils.copyProperties(note, noteDto);
        return noteDto;
    }

    @Override
    public List<NoteDto> getNotesInFolder(NoteDto noteDto) {
        List<Note> notes = this.noteRepository.findAllByFolderIdAndUserIdAndIsInTrash(noteDto.getFolderId(), noteDto.getUserId(),
                false);
        List<NoteDto> noteDtos = new ArrayList<>();

        for (Note note : notes) {
            NoteDto currentNoteDto = new NoteDto();
            BeanUtils.copyProperties(note, currentNoteDto);
            noteDtos.add(currentNoteDto);
        }

        return noteDtos;
    }

    @Override
    public List<NoteDto> getNotesInTrash() {
        List<Note> notes = this.noteRepository.findAllByIsInTrash(true);
        List<NoteDto> noteDtos = new ArrayList<>();

        for (Note note : notes) {
            NoteDto noteDto = new NoteDto();
            BeanUtils.copyProperties(note, noteDto);
            noteDtos.add(noteDto);
        }

        return noteDtos;
    }

    @Override
    public void deleteNote(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserIdAndIsInTrash(noteDto.getId(), noteDto.getUserId(), false);
        note.setInTrash(true);
        this.noteRepository.save(note);
    }

    @Override
    public NoteDto recoverNote(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserIdAndIsInTrash(noteDto.getId(), noteDto.getUserId(), true);
        note.setInTrash(false);
        this.noteRepository.save(note);

        Optional<Folder> folder = this.folderRepository.findByIdAndUserIdAndIsInTrash(noteDto.getFolderId(), noteDto.getUserId(), true);

        if (folder.isPresent()) {
            Folder found = folder.get();
            found.setInTrash(false);
            this.folderRepository.save(found);
        }

        BeanUtils.copyProperties(note, noteDto);
        return noteDto;
    }

    @Override
    public NoteDto updateNoteTitle(NoteDto noteDto) {
        Note note = this.noteRepository.findByIdAndUserIdAndIsInTrash(noteDto.getId(), noteDto.getUserId(), false);
        note.setTitle(noteDto.getTitle());
        this.noteRepository.save(note);
        return noteDto;
    }
}
