package io.knowit.backend.proto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateNoteRequest {
    @NotNull(message = "Please specify a note ID.")
    @Size(min = 1, message = "Please specify a note ID.")
    private String id;

    private String title;
    private String contents;

    public UpdateNoteRequest(String id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
