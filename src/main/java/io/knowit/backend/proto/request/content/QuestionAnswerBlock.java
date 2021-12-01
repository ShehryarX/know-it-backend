package io.knowit.backend.proto.request.content;

public class QuestionAnswerBlock extends ContentBlock {
    private QuestionAnswerBlockDetail data;

    public QuestionAnswerBlock() {
    }

    public QuestionAnswerBlockDetail getData() {
        return data;
    }

    public void setData(QuestionAnswerBlockDetail data) {
        this.data = data;
    }
}
