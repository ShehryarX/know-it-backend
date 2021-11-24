package io.knowit.backend.proto;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateFolderResponse {
    @Id
    @NotNull
    private String id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    private String colour;

    public UpdateFolderResponse() {
    }

    public UpdateFolderResponse(String id, @NotNull @Size(min = 1) String title, @NotNull String colour) {
        this.id = id;
        this.title = title;
        this.colour = colour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
