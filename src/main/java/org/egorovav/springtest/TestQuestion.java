package org.egorovav.springtest;

public interface TestQuestion {
    boolean checkAnswer(String answer);

    String getQuestion();

    String getAnswers();
}
