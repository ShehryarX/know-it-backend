package io.knowit.backend.service.impl;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import io.knowit.backend.config.OpenAiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPTService {

    private static final String SUMMARIZE_ENGINE = "davinci", QA_ENGINE = "davinci-instruct-beta";

    private final OpenAiService service;

    public GPTService(@Autowired OpenAiProperties properties) {
        service = new OpenAiService(properties.secret);
    }

    public static CompletionRequest summarizeRequest(@NonNull String content) {
        return CompletionRequest.builder()
                .temperature(0.3)
                .maxTokens(content.length() / 10)
                .topP(1.0)
                .frequencyPenalty(0.3)
                .presencePenalty(0.0)
                .bestOf(1)
                .prompt(String.format("%s\n\ntl;dr:", content))
                .build();
    }

    public static CompletionRequest keyPointsRequest(@NonNull String content) {
        return CompletionRequest.builder()
                .temperature(0.8)
                .maxTokens(content.length() / 8)
                .topP(1.0)
                .frequencyPenalty(0.0)
                .presencePenalty(0.0)
                .bestOf(2)
                .prompt(String.format("%s\n\nWhat are some key points?\n1.", content))
                .build();
    }

    public static CompletionRequest questionRequest(@NonNull String content) {
        return CompletionRequest.builder()
                .temperature(0.4)
                .maxTokens(64)
                .topP(1.0)
                .frequencyPenalty(0.0)
                .presencePenalty(0.0)
                .bestOf(1)
                .prompt(String.format("%s\n\nCreate a list of questions:\n1.", content))
                .build();
    }

    public CompletionRequest answerRequest(@NonNull String content, @NonNull String question) {
        return CompletionRequest.builder()
                .temperature(0.4)
                .maxTokens(50)
                .topP(1.0)
                .frequencyPenalty(0.0)
                .presencePenalty(0.0)
                .bestOf(1)
                .prompt(String.format("%s\n\n%s\n", content, question))
                .build();
    }

    public List<String> summarize(@NonNull String content) {
        try {
            List<CompletionChoice> results = service.createCompletion(SUMMARIZE_ENGINE, summarizeRequest(content))
                    .getChoices();
            if (results.size() == 0) return Collections.emptyList();

            CompletionChoice result = results.get(0);
            List<String> sentences = Arrays.asList(result.getText().split("\n\n"));
            if(result.getFinish_reason().equals("length") && sentences.size() > 1) {
//                sentences.remove(sentences.size() - 1);
            }
            return sentences;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<String> keyPoints(@NonNull String content) {
        try {
            List<CompletionChoice> results = service.createCompletion(QA_ENGINE, keyPointsRequest(content))
                    .getChoices();
            if (results.size() == 0) return Collections.emptyList();

            CompletionChoice result = results.get(0);
            List<String> pointsText = Arrays.asList(result.getText().split("\n"));
            ArrayList<String> points = new ArrayList<>(pointsText);
            if(result.getFinish_reason().equals("length") && points.size() > 1 && !points.get(points.size() - 1).endsWith(".")) {
                points.remove(points.size() - 1);
            }

            return points.stream().map(s -> {
                if(s.matches("[0-9]+\\..*")) {
                    // Trim digit
                    return s.replaceFirst("[0-9]+\\.", "");
                } else {
                    return s;
                }
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<String> questions(@NonNull String content) {
        try {
            List<CompletionChoice> results = service.createCompletion(QA_ENGINE, questionRequest(content))
                    .getChoices();
            if (results.size() == 0) return Collections.emptyList();

            CompletionChoice result = results.get(0);
            List<String> pointsText = Arrays.asList(result.getText().split("\n"));
            ArrayList<String> points = new ArrayList<>(pointsText);
            if(result.getFinish_reason().equals("length") && points.size() > 1 && !points.get(points.size() - 1).endsWith(".")) {
                points.remove(points.size() - 1);
            }

            return points.stream()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(s -> {
                if(s.matches("[0-9]+\\..*")) {
                    // Trim digit
                    return s.replaceFirst("[0-9]+\\.", "");
                } else {
                    return s;
                }
            }).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public String answer(@NonNull String content, @NonNull String question) {
        try {
            List<CompletionChoice> results = service.createCompletion(QA_ENGINE, answerRequest(content, question))
                    .getChoices();
            if (results.size() == 0) return "";

            CompletionChoice result = results.get(0);
            List<String> sentences = Arrays.asList(result.getText().split("\n"));
            return result.getText();
        } catch (Exception e) {
            return "";
        }
    }


}
