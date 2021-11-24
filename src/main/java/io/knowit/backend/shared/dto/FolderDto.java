package io.knowit.backend.shared.dto;

public class FolderDto {
    private String id;
    private String title;
    private String colour;
    private String userId;

    public FolderDto() {
    }

    public FolderDto(String id, String title, String colour, String userId) {
        this.id = id;
        this.title = title;
        this.colour = colour;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
