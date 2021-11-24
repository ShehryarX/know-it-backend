package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.Folder;
import io.knowit.backend.io.repository.FolderRepository;
import io.knowit.backend.service.FolderService;
import io.knowit.backend.shared.dto.FolderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {
    private FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

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
        Folder folder = new Folder();
        BeanUtils.copyProperties(folderDto, folder);
        folderRepository.deleteByIdAndUserId(folder.getId(), folder.getUserId());
    }

    @Override
    public FolderDto updateFolder(FolderDto folderDto) {
        Folder folder = folderRepository.findByIdAndUserId(folderDto.getId(), folderDto.getUserId());
        folder.setTitle(folderDto.getTitle());
        folder.setColour(folderDto.getColour());
        folderRepository.save(folder);
        BeanUtils.copyProperties(folder, folderDto);
        return folderDto;
    }

    @Override
    public List<FolderDto> getAllFolders(String userId) {
        List<Folder> folders = folderRepository.findAllByUserId(userId);
        List<FolderDto> foldersDtos = new ArrayList<>();

        for (Folder folder : folders) {
            FolderDto folderDto = new FolderDto();
            BeanUtils.copyProperties(folder, folderDto);
            foldersDtos.add(folderDto);
        }

        return foldersDtos;
    }
}
