package io.knowit.backend.proto.response;

import java.util.ArrayList;
import java.util.List;

public class GetFolderWithNotesResponse extends FolderResponse {
    List<BriefNoteDescriptionResponse> notes = new ArrayList<>();

    public GetFolderWithNotesResponse() {
    }

    public GetFolderWithNotesResponse(List<BriefNoteDescriptionResponse> notes) {
        this.notes = notes;
    }

    public GetFolderWithNotesResponse(String id, String title, String colour, List<BriefNoteDescriptionResponse> notes) {
        super(id, title, colour);
        this.notes = notes;
    }

    public List<BriefNoteDescriptionResponse> getNotes() {
        return notes;
    }

    public void setNotes(List<BriefNoteDescriptionResponse> notes) {
        this.notes = notes;
    }

    public void addNote(BriefNoteDescriptionResponse note) {
        this.notes.add(note);
    }
}
