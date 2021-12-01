package io.knowit.backend.service.impl;

import io.knowit.backend.proto.request.content.ContentRequest;

public class GenerateFlashcardRequest {
    private String id;
    private String title;
    private String contents;

    public GenerateFlashcardRequest() {
    }

    public GenerateFlashcardRequest(String id, String title, String contents) {
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
