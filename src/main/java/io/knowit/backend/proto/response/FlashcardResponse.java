package io.knowit.backend.proto.response;

public class FlashcardResponse {
    private String id;
    private String question;
    private String answer;
    private String noteId;
    private String userId;

    public FlashcardResponse() {
    }

    public FlashcardResponse(String id, String question, String answer, String noteId, String userId) {
        this.id = id;
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
