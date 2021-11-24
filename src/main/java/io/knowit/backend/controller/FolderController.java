package io.knowit.backend.controller;

import io.knowit.backend.io.entity.FolderEntity;
import io.knowit.backend.io.entity.NoteEntity;
import io.knowit.backend.proto.*;
import io.knowit.backend.service.FolderService;
import io.knowit.backend.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {
    private FolderService folderService;
    private NoteService noteService;

    public FolderController(FolderService folderService, NoteService noteService) {
        this.folderService = folderService;
        this.noteService = noteService;
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public List<GetFoldersResponseItem> getFolders() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        List<FolderEntity> folders = this.folderService.getAllFolders(userId);

        List<GetFoldersResponseItem> items = new ArrayList<>();

        for (FolderEntity folder : folders) {
            GetFoldersResponseItem item = new GetFoldersResponseItem();
            BeanUtils.copyProperties(folder, item);
            items.add(item);
        }

        return items;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public CreateFolderResponse createFolder(@Valid @RequestBody CreateFolderRequest createFolderRequest) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderEntity folderEntity = new FolderEntity();
        BeanUtils.copyProperties(createFolderRequest, folderEntity);

        String userId = auth.getName();
        folderEntity.setUserEntityId(userId);

        this.folderService.createFolder(folderEntity);

        CreateFolderResponse folder = new CreateFolderResponse();
        BeanUtils.copyProperties(folderEntity, folder);

        return folder;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    public UpdateFolderResponse updateFolder(@Valid @RequestBody UpdateFolderRequest updateFolderRequest) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderEntity folderEntity = new FolderEntity();
        BeanUtils.copyProperties(updateFolderRequest, folderEntity);

        String userId = auth.getName();
        folderEntity.setUserEntityId(userId);

        this.folderService.updateFolder(folderEntity);

        UpdateFolderResponse folder = new UpdateFolderResponse();
        BeanUtils.copyProperties(folderEntity, folder);

        return folder;
    }

    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    public void deleteFolder(@RequestParam("id") String folderId) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setId(folderId);

        String userId = auth.getName();
        folderEntity.setUserEntityId(userId);

        this.folderService.deleteFolder(folderEntity);
    }

    @GetMapping(value = "/with-notes", consumes = "application/json", produces = "application/json")
    public List<GetFolderWithNotesResponseItem> getFoldersWithNotes() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        List<GetFolderWithNotesResponseItem> foldersWithNotes = new ArrayList<>();
        List<FolderEntity> folders = this.folderService.getAllFolders(userId);

        for (FolderEntity folder : folders) {
            GetFolderWithNotesResponseItem item = new GetFolderWithNotesResponseItem();
            BeanUtils.copyProperties(folder, item);

            NoteEntity queryNote = new NoteEntity();
            queryNote.setFolderEntityId(folder.getId());
            queryNote.setUserEntityId(userId);

            List<NoteEntity> notes = this.noteService.getNotesInFolder(queryNote);

            for (NoteEntity note : notes) {
                GetFolderWithNotesResponseItemNote noteItem = new GetFolderWithNotesResponseItemNote();
                BeanUtils.copyProperties(note, noteItem);
                item.addNote(noteItem);
            }

            foldersWithNotes.add(item);
        }

        return foldersWithNotes;
    }
}
