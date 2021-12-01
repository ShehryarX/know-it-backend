package io.knowit.backend.proto.request.content;

import java.util.List;

public class ContentRequest {
    private String time;
    private String version;
    private List<ContentBlock> blocks;

    public ContentRequest() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ContentBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<ContentBlock> blocks) {
        this.blocks = blocks;
    }
}