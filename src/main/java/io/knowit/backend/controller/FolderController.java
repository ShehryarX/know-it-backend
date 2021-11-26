package io.knowit.backend.controller;

import io.knowit.backend.exception.BodyValidationException;
import io.knowit.backend.proto.request.CreateFolderRequest;
import io.knowit.backend.proto.request.UpdateFolderRequest;
import io.knowit.backend.proto.response.FolderResponse;
import io.knowit.backend.proto.response.GetFolderWithNotesResponse;
import io.knowit.backend.proto.response.BriefNoteDescriptionResponse;
import io.knowit.backend.security.CurrentUser;
import io.knowit.backend.security.UserPrincipal;
import io.knowit.backend.service.FolderService;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.FolderDto;
import io.knowit.backend.shared.dto.NoteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("folders")
public class FolderController {
    private FolderService folderService;
    private NoteService noteService;

    public FolderController(FolderService folderService, NoteService noteService) {
        this.folderService = folderService;
        this.noteService = noteService;
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public List<FolderResponse> getFolders(@CurrentUser UserPrincipal userPrincipal) throws Exception {
        List<FolderDto> folders = this.folderService.getAllFolders(userPrincipal.getId());
        List<FolderResponse> response = new ArrayList<>();

        for (FolderDto folder : folders) {
            FolderResponse item = new FolderResponse();
            BeanUtils.copyProperties(folder, item);
            response.add(item);
        }

        return response;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public FolderResponse createFolder(@Valid @RequestBody CreateFolderRequest createFolderRequest, Errors errors,
                                       @CurrentUser UserPrincipal userPrincipal) throws Exception {
        if (errors.hasErrors()) {
            throw new BodyValidationException(errors);
        }

        FolderDto folderDto = new FolderDto();
        BeanUtils.copyProperties(createFolderRequest, folderDto);
        folderDto.setUserId(userPrincipal.getId());
        FolderDto createdFolded = this.folderService.createFolder(folderDto);

        FolderResponse response = new FolderResponse();
        BeanUtils.copyProperties(createdFolded, response);

        return response;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public FolderResponse updateFolder(@Valid @RequestBody UpdateFolderRequest updateFolderRequest, Errors errors,
                                       @CurrentUser UserPrincipal userPrincipal) throws Exception {
        if (errors.hasErrors()) {
            throw new BodyValidationException(errors);
        }

        FolderDto folderDto = new FolderDto();
        BeanUtils.copyProperties(updateFolderRequest, folderDto);
        folderDto.setUserId(userPrincipal.getId());
        FolderDto updatedFolder = this.folderService.updateFolder(folderDto);

        FolderResponse response = new FolderResponse();
        BeanUtils.copyProperties(updatedFolder, response);

        return response;
    }

    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public void deleteFolder(@RequestParam("id") String folderId, @CurrentUser UserPrincipal userPrincipal) throws Exception {
        FolderDto folder = new FolderDto();
        folder.setId(folderId);
        folder.setUserId(userPrincipal.getId());
        this.folderService.deleteFolder(folder);
    }

    @GetMapping(value = "/with-notes", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public List<GetFolderWithNotesResponse> getFoldersWithNotes(@CurrentUser UserPrincipal userPrincipal) throws Exception {
        List<GetFolderWithNotesResponse> foldersWithNotes = new ArrayList<>();
        List<FolderDto> folders = this.folderService.getAllFolders(userPrincipal.getId());

        for (FolderDto folder : folders) {
            GetFolderWithNotesResponse item = new GetFolderWithNotesResponse();
            BeanUtils.copyProperties(folder, item);

            NoteDto noteDto = new NoteDto();
            noteDto.setFolderId(folder.getId());
            noteDto.setUserId(userPrincipal.getId());

            List<NoteDto> notes = this.noteService.getNotesInFolder(noteDto);

            for (NoteDto note : notes) {
                BriefNoteDescriptionResponse noteItem = new BriefNoteDescriptionResponse();
                BeanUtils.copyProperties(note, noteItem);
                item.addNote(noteItem);
            }

            foldersWithNotes.add(item);
        }

        return foldersWithNotes;
    }
}
