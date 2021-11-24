package io.knowit.backend.proto;

import com.mongodb.lang.NonNull;

public class DeleteFolderRequest {
    @NonNull
    String folderId;

    public DeleteFolderRequest(@NonNull String folderId) {
        this.folderId = folderId;
    }

    @NonNull
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(@NonNull String folderId) {
        this.folderId = folderId;
    }
}


