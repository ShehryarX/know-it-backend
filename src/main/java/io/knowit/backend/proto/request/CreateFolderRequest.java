package io.knowit.backend.proto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateFolderRequest {
    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    @Size(min = 1)
    private String colour;

    public CreateFolderRequest(@NotNull @Size(min = 1) String title, @NotNull String colour) {
        this.title = title;
        this.colour = colour;
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


