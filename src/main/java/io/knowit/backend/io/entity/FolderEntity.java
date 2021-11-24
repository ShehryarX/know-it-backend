package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class FolderEntity {
    @Id
    private String id;

    @NonNull
    @Size(min = 1)
    private String title;

    @NonNull
    @Size(min = 1)
    private String colour;

    @NonNull
    @Size(min = 1)
    private String userEntityId;

    public FolderEntity() {
    }

    public FolderEntity(@NonNull @Size(min = 1) String title, @NonNull @Size(min = 1) String colour, @NonNull @Size(min = 1) String userEntityId) {
        this.title = title;
        this.colour = colour;
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
    public String getColour() {
        return colour;
    }

    public void setColour(@NonNull String colour) {
        this.colour = colour;
    }

    @NonNull
    public String getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(@NonNull String userEntityId) {
        this.userEntityId = userEntityId;
    }
}
