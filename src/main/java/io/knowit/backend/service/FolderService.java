package io.knowit.backend.service;

import io.knowit.backend.io.entity.FolderEntity;

import java.util.List;

public interface FolderService {
    void createFolder(FolderEntity folder) throws Exception;
    void deleteFolder(FolderEntity deleteFolderRequest) throws Exception;
    void updateFolder(FolderEntity renameFolderRequest) throws Exception;
    List<FolderEntity> getAllFolders(String userId);
}
