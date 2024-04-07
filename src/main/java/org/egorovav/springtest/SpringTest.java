package org.egorovav.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class SpringTest {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringTestApplicationContext.class);

        AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
        List<TestQuestion> questions = (List<TestQuestion>)ctx.getBean("questions");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you name, please.");
        String name = scanner.nextLine();
        System.out.println("Enter you surname, please.");
        String surname = scanner.nextLine();
        System.out.format("%s %s, please, answer %d questions.\n", name, surname, questions.size());
        System.out.format("The pass result is %d correct answers.\n", appProperty.getPassValue());
        int correctAnswersAmount = 0;
        for(int i = 0; i < questions.size(); i++) {
            System.out.format("%d. %s.\n", i + 1, questions.get(i).getQuestion());
            System.out.format("Choose one: %s\n", questions.get(i).getAnswers());
            String answer = scanner.nextLine();
            if(questions.get(i).checkAnswer(answer)) {
                correctAnswersAmount++;
            }
        }
        if(correctAnswersAmount < appProperty.getPassValue()) {
            System.out.println("Test is not passed.");
        } else {
            System.out.println("Congratulations! Test is passed.");
        }

    }
}
