package io.knowit.backend.io.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class Flashcard {
    @Id
    private String id;

    @NonNull
    @Size(min = 1)
    private String question;

    @NonNull
    @Size(min = 1)
    private String answer;

    @NonNull
    @Size(min = 1)
    private String noteId;

    private String userId;

    public Flashcard() {
    }

    public Flashcard(@NonNull @Size(min = 1) String question, @NonNull @Size(min = 1) String answer, @NonNull @Size(min = 1) String noteId, String userId) {
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

    @NonNull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    @NonNull
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(@NonNull String answer) {
        this.answer = answer;
    }

    @NonNull
    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(@NonNull String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
