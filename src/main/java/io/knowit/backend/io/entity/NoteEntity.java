package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Size;
import java.util.Date;

public class NoteEntity {
    @Id
    private String id;

    @NonNull
    private String title;

    @NonNull
    private String contents;

    @LastModifiedDate
    private Date timeUpdated;

    @NonNull
    @Size(min = 1)
    private String folderEntityId;

    @NonNull
    @Size(min = 1)
    private String userEntityId;

    public NoteEntity() {
    }

    public NoteEntity(@NonNull String title, @NonNull String contents, Date timeUpdated, @NonNull @Size(min = 1) String folderEntityId, @NonNull @Size(min = 1) String userEntityId) {
        this.title = title;
        this.contents = contents;
        this.timeUpdated = timeUpdated;
        this.folderEntityId = folderEntityId;
        this.userEntityId = userEntityId;
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
    public String getFolderEntityId() {
        return folderEntityId;
    }

    public void setFolderEntityId(@NonNull String folderEntityId) {
        this.folderEntityId = folderEntityId;
    }

    @NonNull
    public String getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(@NonNull String userEntityId) {
        this.userEntityId = userEntityId;
    }
}
