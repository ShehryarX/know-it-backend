package io.knowit.backend.service;

import io.knowit.backend.shared.dto.FolderDto;

import java.util.List;

public interface FolderService {
    FolderDto createFolder(FolderDto folder) throws Exception;
    FolderDto updateFolder(FolderDto renameFolderRequest) throws Exception;
    List<FolderDto> getAllFolders(String userId) throws Exception;
    void deleteFolder(FolderDto deleteFolderRequest) throws Exception;
}
