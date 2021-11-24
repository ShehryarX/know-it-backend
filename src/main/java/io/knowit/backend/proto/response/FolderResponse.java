package io.knowit.backend.proto.response;

public class FolderResponse {
    private String id;
    private String title;
    private String colour;

    public FolderResponse() {
    }

    public FolderResponse(String id, String title, String colour) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
