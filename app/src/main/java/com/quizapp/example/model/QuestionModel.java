package com.quizapp.example.model;

public class QuestionModel {
    private Integer txtQuestion; // Not in the pot, it boils in winter and summer without stopping!
    private String answer; // Spring (water source)
    private String variant; // baulgdqos

    public QuestionModel(int txtQuestion, String answer, String variant) {
        this.txtQuestion = txtQuestion;
        this.answer = answer;
        this.variant = variant;
    }

    public Integer getTxtQuestion() {
        return txtQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public String getVariant() {
        return variant;
    }
}
