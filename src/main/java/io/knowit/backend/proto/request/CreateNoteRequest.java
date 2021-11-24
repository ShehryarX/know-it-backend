package io.knowit.backend.proto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateNoteRequest {
    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    @Size(min = 1)
    private String folderId;

    public CreateNoteRequest(String title, String folderId) {
        this.title = title;
        this.folderId = folderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getfolderId() {
        return folderId;
    }

    public void setfolderId(String folderId) {
        this.folderId = folderId;
    }
}
