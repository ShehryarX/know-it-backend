package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Size;
import java.util.Date;

public class Note {
    @Id
    private String id;

    @NonNull
    @Size(min = 1)
    private String title;

    @NonNull
    @Size(min = 1)
    private String contents;

    @LastModifiedDate
    private Date timeUpdated;

    @NonNull
    @Size(min = 1)
    private String folderId;

    @NonNull
    @Size(min = 1)
    private String userId;

    public Note() {
    }

    public Note(@NonNull String title, @NonNull String contents, Date timeUpdated, @NonNull @Size(min = 1) String folderId, @NonNull @Size(min = 1) String userId) {
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

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getContents() {
        return contents;
    }

    public void setContents(@NonNull String contents) {
        this.contents = contents;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @NonNull
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(@NonNull String folderId) {
        this.folderId = folderId;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }
}
