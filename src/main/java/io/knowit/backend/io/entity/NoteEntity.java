package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

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
    private FolderEntity folderEntity;

    public NoteEntity(@NonNull String title, @NonNull String contents, Date timeUpdated, @NonNull FolderEntity folderEntity) {
        this.title = title;
        this.contents = contents;
        this.timeUpdated = timeUpdated;
        this.folderEntity = folderEntity;
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
    public FolderEntity getFolderEntity() {
        return folderEntity;
    }

    public void setFolderEntity(@NonNull FolderEntity folderEntity) {
        this.folderEntity = folderEntity;
    }
}
