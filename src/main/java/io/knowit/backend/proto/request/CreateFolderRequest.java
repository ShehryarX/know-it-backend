package io.knowit.backend.proto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateFolderRequest {
    @NotNull(message = "Please enter a title.")
    @Size(min = 1, max = 150, message = "Please enter a title.")
    private String title;

    @NotNull(message = "Please select a colour.")
    @Size(min = 1, max = 100, message = "Please select a colour.")
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


