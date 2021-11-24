package io.knowit.backend.io.model;

import com.mongodb.lang.NonNull;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class Folder {
    @Id
    private String id;

    @NonNull
    @Size(min = 1)
    private String title;

    @NonNull
    private String colour;

    @NonNull
    private ApplicationUser applicationUser;

    public Folder(@NonNull @Size(min = 1) String title, @NonNull String colour, @NonNull ApplicationUser applicationUser) {
        this.title = title;
        this.colour = colour;
        this.applicationUser = applicationUser;
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
    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(@NonNull ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }
}
