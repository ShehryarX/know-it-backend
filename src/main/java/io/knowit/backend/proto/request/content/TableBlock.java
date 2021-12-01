package io.knowit.backend.proto.request.content;

import java.util.List;

public class TableBlock extends ContentBlock {
    class TableBlockDetail {
        private List<List<String>> content;

        public TableBlockDetail() {
        }

        public List<List<String>> getContent() {
            return content;
        }

        public void setContent(List<List<String>> content) {
            this.content = content;
        }
    }

    private TableBlockDetail data;

    public TableBlock() {
    }

    public TableBlockDetail getData() {
        return data;
    }

    public void setData(TableBlockDetail data) {
        this.data = data;
    }
}

