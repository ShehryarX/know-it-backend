package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class Folder {
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
    private String userId;

    @NonNull
    private Boolean isInTrash = false;

    public Folder() {
    }

    public Folder(String id, @NonNull @Size(min = 1) String title, @NonNull @Size(min = 1) String colour, @NonNull @Size(min = 1) String userId, @NonNull Boolean isInTrash) {
        this.id = id;
        this.title = title;
        this.colour = colour;
        this.userId = userId;
        this.isInTrash = isInTrash;
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
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public Boolean getInTrash() {
        return isInTrash;
    }

    public void setInTrash(@NonNull Boolean inTrash) {
        isInTrash = inTrash;
    }
}
