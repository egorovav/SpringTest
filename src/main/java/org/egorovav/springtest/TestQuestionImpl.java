package org.egorovav.springtest;

import java.util.Arrays;

public class TestQuestionImpl implements TestQuestion {

    String question;
    String answers;
    String correctAnswer;

    public TestQuestionImpl(String inputString) {
        String[] inputArray = inputString.split(",");
        question = inputArray[0];
        answers = String.join(",", Arrays.copyOfRange(inputArray, 1, 3));
        correctAnswer = inputArray[4];
    }

    public boolean checkAnswer(String answer) {
        return answer == correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswers() {
        return answers;
    }
}
