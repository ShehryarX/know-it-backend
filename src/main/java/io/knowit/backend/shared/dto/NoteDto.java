package io.knowit.backend.shared.dto;

import java.util.Date;

public class NoteDto {
    private String id;
    private String title;
    private String contents;
    private Date timeUpdated;
    private String folderName;
    private String folderId;
    private String userId;

    public NoteDto() {
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public NoteDto(String id, String title, String contents, Date timeUpdated, String folderId, String userId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.timeUpdated = timeUpdated;
        this.folderId = folderId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
