package io.knowit.backend.proto.request.content;

public class ParagraphBlock extends ContentBlock {
    public class ParagraphBlockDetail {
        private String text;

        public ParagraphBlockDetail() {
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    private ParagraphBlockDetail data;

    public ParagraphBlock() {
    }

    public ParagraphBlockDetail getData() {
        return data;
    }

    public void setData(ParagraphBlockDetail data) {
        this.data = data;
    }
}
