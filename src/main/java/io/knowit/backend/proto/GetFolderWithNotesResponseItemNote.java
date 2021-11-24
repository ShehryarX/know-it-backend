package io.knowit.backend.proto;

import java.util.Date;

public class GetFolderWithNotesResponseItemNote {
    private String id;
    private String title;
    private Date timeUpdated;
    private String folderEntityId;

    public GetFolderWithNotesResponseItemNote() {
    }

    public GetFolderWithNotesResponseItemNote(String id, String title, String contents, Date timeUpdated, String folderEntityId) {
        this.id = id;
        this.title = title;
        this.timeUpdated = timeUpdated;
        this.folderEntityId = folderEntityId;
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

    public String getFolderEntityId() {
        return folderEntityId;
    }

    public void setFolderEntityId(String folderEntityId) {
        this.folderEntityId = folderEntityId;
    }
}
