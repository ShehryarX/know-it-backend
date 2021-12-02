package io.knowit.backend.proto.request.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HeaderBlock.class, name = "header"),
        @JsonSubTypes.Type(value = ParagraphBlock.class, name = "paragraph"),
        @JsonSubTypes.Type(value = QuestionAnswerBlock.class, name = "qa"),
        @JsonSubTypes.Type(value = ListBlock.class, name = "list"),
        @JsonSubTypes.Type(value = TableBlock.class, name = "table"),
})
public class ContentBlock {
    private String type;
    private String id;

    public ContentBlock() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
