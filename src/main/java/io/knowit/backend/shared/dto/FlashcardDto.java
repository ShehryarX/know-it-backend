package io.knowit.backend.shared.dto;

import io.knowit.backend.proto.request.content.ContentRequest;

public class FlashcardDto {
    private String id;
    private ContentRequest contents;
    private String question;
    private String answer;
    private String noteId;
    private String userId;

    public FlashcardDto() {
    }

    public FlashcardDto(String id, ContentRequest contents, String question, String answer, String noteId, String userId) {
        this.id = id;
        this.contents = contents;
        this.question = question;
        this.answer = answer;
        this.noteId = noteId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContentRequest getContents() {
        return contents;
    }

    public void setContents(ContentRequest contents) {
        this.contents = contents;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
