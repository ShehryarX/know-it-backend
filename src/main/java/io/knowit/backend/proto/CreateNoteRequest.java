package io.knowit.backend.proto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateNoteRequest {
    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    @Size(min = 1)
    private String folderEntityId;

    public CreateNoteRequest(String title, String folderEntityId) {
        this.title = title;
        this.folderEntityId = folderEntityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderEntityId() {
        return folderEntityId;
    }

    public void setFolderEntityId(String folderEntityId) {
        this.folderEntityId = folderEntityId;
    }
}
