package io.knowit.backend.controller;

import io.knowit.backend.io.entity.FolderEntity;
import io.knowit.backend.proto.CreateFolderRequest;
import io.knowit.backend.service.FolderService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/folders")
public class FolderController {
    private FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public void createFolder(@Valid @RequestBody CreateFolderRequest createFolderRequest) throws Exception {
        FolderEntity folderEntity = new FolderEntity();
        BeanUtils.copyProperties(createFolderRequest, folderEntity);
        this.folderService.createFolder(folderEntity);
    }
}
