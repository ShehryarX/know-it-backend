package io.knowit.backend.controller;

import io.knowit.backend.proto.request.CreateFolderRequest;
import io.knowit.backend.proto.request.UpdateFolderRequest;
import io.knowit.backend.proto.response.FolderResponse;
import io.knowit.backend.proto.response.GetFolderWithNotesResponse;
import io.knowit.backend.proto.response.BriefNoteDescriptionResponse;
import io.knowit.backend.service.FolderService;
import io.knowit.backend.service.NoteService;
import io.knowit.backend.shared.dto.FolderDto;
import io.knowit.backend.shared.dto.NoteDto;
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
    public List<FolderResponse> getFolders() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        List<FolderDto> folders = this.folderService.getAllFolders(userId);
        List<FolderResponse> response = new ArrayList<>();

        for (FolderDto folder : folders) {
            FolderResponse item = new FolderResponse();
            BeanUtils.copyProperties(folder, item);
            response.add(item);
        }

        return response;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public FolderResponse createFolder(@Valid @RequestBody CreateFolderRequest createFolderRequest) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderDto folderDto = new FolderDto();
        BeanUtils.copyProperties(createFolderRequest, folderDto);

        String userId = auth.getName();
        folderDto.setUserId(userId);

        FolderDto createdFolded = this.folderService.createFolder(folderDto);

        FolderResponse response = new FolderResponse();
        BeanUtils.copyProperties(createdFolded, response);

        return response;
    }

    @PutMapping(value = "", consumes = "application/json", produces = "application/json")
    public FolderResponse updateFolder(@Valid @RequestBody UpdateFolderRequest updateFolderRequest) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderDto folderDto = new FolderDto();
        BeanUtils.copyProperties(updateFolderRequest, folderDto);

        String userId = auth.getName();
        folderDto.setUserId(userId);

        FolderDto updatedFolder = this.folderService.updateFolder(folderDto);

        FolderResponse response = new FolderResponse();
        BeanUtils.copyProperties(updatedFolder, response);

        return response;
    }

    @DeleteMapping(value = "", consumes = "application/json", produces = "application/json")
    public void deleteFolder(@RequestParam("id") String folderId) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        FolderDto folder = new FolderDto();
        folder.setId(folderId);

        String userId = auth.getName();
        folder.setUserId(userId);

        this.folderService.deleteFolder(folder);
    }

    @GetMapping(value = "/with-notes", consumes = "application/json", produces = "application/json")
    public List<GetFolderWithNotesResponse> getFoldersWithNotes() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        List<GetFolderWithNotesResponse> foldersWithNotes = new ArrayList<>();
        List<FolderDto> folders = this.folderService.getAllFolders(userId);

        for (FolderDto folder : folders) {
            GetFolderWithNotesResponse item = new GetFolderWithNotesResponse();
            BeanUtils.copyProperties(folder, item);

            NoteDto noteDto = new NoteDto();
            noteDto.setFolderId(folder.getId());
            noteDto.setUserId(userId);

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
