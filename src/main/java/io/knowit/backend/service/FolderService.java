package io.knowit.backend.service;

import io.knowit.backend.io.entity.FolderEntity;

public interface FolderService {
    void createFolder(FolderEntity createFolderRequest) throws Exception;
    void deleteFolder(FolderEntity deleteFolderRequest) throws Exception;
    void renameFolder(FolderEntity renameFolderRequest) throws Exception;
}
