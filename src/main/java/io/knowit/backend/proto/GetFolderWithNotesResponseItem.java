package io.knowit.backend.proto;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class GetFolderWithNotesResponseItem {
    @Id
    private String id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    private String colour;

    List<GetFolderWithNotesResponseItemNote> notes = new ArrayList<>();

    public GetFolderWithNotesResponseItem() {
    }

    public GetFolderWithNotesResponseItem(String id, @NotNull @Size(min = 1) String title, @NotNull String colour, List<GetFolderWithNotesResponseItemNote> notes) {
        this.id = id;
        this.title = title;
        this.colour = colour;
        this.notes = notes;
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

    public List<GetFolderWithNotesResponseItemNote> getNotes() {
        return notes;
    }

    public void setNotes(List<GetFolderWithNotesResponseItemNote> notes) {
        this.notes = notes;
    }

    public void addNote(GetFolderWithNotesResponseItemNote note) {
        this.notes.add(note);
    }
}
