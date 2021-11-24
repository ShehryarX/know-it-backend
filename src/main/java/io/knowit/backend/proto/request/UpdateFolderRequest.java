package io.knowit.backend.proto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateFolderRequest {
    @NotNull
    @Size(min = 1)
    private String id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    private String colour;

    public UpdateFolderRequest(@NotNull @Size(min = 1) String id, @NotNull @Size(min = 1) String title, @NotNull String colour) {
        this.id = id;
        this.title = title;
        this.colour = colour;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getColour() {
        return colour;
    }

    public void setColour(@NotNull String colour) {
        this.colour = colour;
    }
}


