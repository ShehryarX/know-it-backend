package io.knowit.backend.proto.response;

import java.util.Date;

public class BriefNoteDescriptionResponse {
    private String id;
    private String title;
    private Date timeUpdated;
    private String folderId;

    public BriefNoteDescriptionResponse() {
    }

    public BriefNoteDescriptionResponse(String id, String title, String contents, Date timeUpdated, String folderId) {
        this.id = id;
        this.title = title;
        this.timeUpdated = timeUpdated;
        this.folderId = folderId;
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
