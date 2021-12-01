package io.knowit.backend.proto.request.content;

public class HeaderBlock extends ContentBlock {
    class HeaderBlockDetail {
        private String text;
        private String level;

        public HeaderBlockDetail() {
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }

    private HeaderBlockDetail data;

    public HeaderBlock() {
    }

    public HeaderBlock(HeaderBlockDetail data) {
        this.data = data;
    }

    public HeaderBlockDetail getData() {
        return data;
    }

    public void setData(HeaderBlockDetail data) {
        this.data = data;
    }
}