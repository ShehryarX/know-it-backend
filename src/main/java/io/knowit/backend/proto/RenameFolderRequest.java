package io.knowit.backend.proto;

import com.mongodb.lang.NonNull;

import javax.validation.constraints.Size;

public class RenameFolderRequest {
    @NonNull
    @Size(min = 1)
    private String folderId;

    @NonNull
    @Size(min = 1)
    private String title;

    @NonNull
    private String colour;

    public RenameFolderRequest(@NonNull @Size(min = 1) String folderId, @NonNull @Size(min = 1) String title, @NonNull String colour) {
        this.folderId = folderId;
        this.title = title;
        this.colour = colour;
    }

    @NonNull
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(@NonNull String folderId) {
        this.folderId = folderId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getColour() {
        return colour;
    }

    public void setColour(@NonNull String colour) {
        this.colour = colour;
    }
}


