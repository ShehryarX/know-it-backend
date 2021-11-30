package io.knowit.backend.proto.response;

import java.util.Date;

public class BriefNoteDescriptionResponse {
    private String id;
    private String title;
    private Date timeUpdated;
    private String folderId;
    private String folderTitle;

    public BriefNoteDescriptionResponse() {
    }

    public BriefNoteDescriptionResponse(String id, String title, Date timeUpdated, String folderId, String folderTitle) {
        this.id = id;
        this.title = title;
        this.timeUpdated = timeUpdated;
        this.folderId = folderId;
        this.folderTitle = folderTitle;
    }

    public String getFolderTitle() {
        return folderTitle;
    }

    public void setFolderTitle(String folderTitle) {
        this.folderTitle = folderTitle;
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
}
