package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.Folder;
import io.knowit.backend.io.entity.Note;
import io.knowit.backend.io.repository.FolderRepository;
import io.knowit.backend.io.repository.NoteRepository;
import io.knowit.backend.service.FolderService;
import io.knowit.backend.shared.dto.FolderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public FolderDto createFolder(FolderDto folderDto) {
        Folder folder = new Folder();
        BeanUtils.copyProperties(folderDto, folder);
        folderRepository.save(folder);
        BeanUtils.copyProperties(folder, folderDto);
        return folderDto;
    }

    @Override
    public void deleteFolder(FolderDto folderDto) {
        List<Note> notes = this.noteRepository.findAllByFolderIdAndUserIdAndInTrash(folderDto.getId(), folderDto.getUserId(), false);

        for (Note note : notes) {
            note.setInTrash(true);
            this.noteRepository.save(note);
        }

        Folder folder = this.folderRepository.findById(folderDto.getId()).get();
        folder.setInTrash(true);
        this.folderRepository.save(folder);
    }

    @Override
    public FolderDto updateFolder(FolderDto folderDto) {
        Folder folder = folderRepository.findByIdAndUserIdAndInTrash(folderDto.getId(), folderDto.getUserId(), false).get();
        folder.setTitle(folderDto.getTitle());
        folder.setColour(folderDto.getColour());
        folderRepository.save(folder);
        BeanUtils.copyProperties(folder, folderDto);
        return folderDto;
    }

    @Override
    public List<FolderDto> getAllFolders(String userId) {
        List<Folder> folders = folderRepository.findAllByUserIdAndInTrash(userId, false);
        List<FolderDto> foldersDtos = new ArrayList<>();

        for (Folder folder : folders) {
            FolderDto folderDto = new FolderDto();
            BeanUtils.copyProperties(folder, folderDto);
            foldersDtos.add(folderDto);
        }

        return foldersDtos;
    }
}
