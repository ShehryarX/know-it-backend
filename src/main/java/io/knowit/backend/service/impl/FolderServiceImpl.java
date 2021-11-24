package io.knowit.backend.service.impl;

import io.knowit.backend.exception.FolderNotFoundException;
import io.knowit.backend.io.entity.FolderEntity;
import io.knowit.backend.io.repository.FolderRepository;
import io.knowit.backend.service.FolderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderServiceImpl implements FolderService {
    private FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public void createFolder(FolderEntity folder) throws Exception {
        folderRepository.save(folder);
    }

    @Override
    public void deleteFolder(FolderEntity folder) throws Exception {
        folderRepository.deleteByIdAndUserEntityId(folder.getId(), folder.getUserEntityId());
    }

    @Override
    public void updateFolder(FolderEntity folder) throws Exception {
        FolderEntity entity = folderRepository.findByIdAndUserEntityId(folder.getId(), folder.getUserEntityId());
        entity.setTitle(folder.getTitle());
        entity.setColour(folder.getColour());
        folderRepository.save(entity);
    }

    @Override
    public List<FolderEntity> getAllFolders(String userId) {
        return folderRepository.findAllByUserEntityId(userId);
    }
}
