package org.egorovav.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringTest {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringTestApplicationContext.class);

        AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
        System.out.println(appProperty.testPath);
        System.out.println(appProperty.passValue);

        List<TestQuestion> questions = (List<TestQuestion>)ctx.getBean("questions");
        System.out.println(questions.size());
    }
}
