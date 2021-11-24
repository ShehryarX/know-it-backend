package io.knowit.backend.service.impl;

import io.knowit.backend.io.entity.FolderEntity;
import io.knowit.backend.io.repository.FolderRepository;
import io.knowit.backend.service.FolderService;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {
    private FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public void createFolder(FolderEntity createFolderRequest) throws Exception {
        folderRepository.save(createFolderRequest);
    }

    @Override
    public void deleteFolder(FolderEntity deleteFolderRequest) throws Exception {

    }

    @Override
    public void renameFolder(FolderEntity renameFolderRequest) throws Exception {

    }
}
