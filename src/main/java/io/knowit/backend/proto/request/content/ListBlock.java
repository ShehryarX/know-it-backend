package io.knowit.backend.proto.request.content;

import java.util.List;

public class ListBlock extends ContentBlock {
    class ListBlockDetail {
        private String style;
        private List<String> items;

        public ListBlockDetail() {
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }
    }

    private ListBlockDetail data;

    public ListBlock() {
    }

    public ListBlockDetail getData() {
        return data;
    }

    public void setData(ListBlockDetail data) {
        this.data = data;
    }
}
