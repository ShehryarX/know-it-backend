package io.knowit.backend.proto.response;

import java.util.Date;

public class NoteResponse {
    private String id;
    private String title;
    private String contents;
    private Date timeUpdated;
    private String folderId;

    public NoteResponse() {
    }

    public NoteResponse(String id, String title, String contents, Date timeUpdated, String folderId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
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

    public String getfolderId() {
        return folderId;
    }

    public void setfolderId(String folderId) {
        this.folderId = folderId;
    }
}
