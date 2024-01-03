package com.QuizApp.Quiz.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubmitResponse {

    private Integer id;
    private String response;
}
