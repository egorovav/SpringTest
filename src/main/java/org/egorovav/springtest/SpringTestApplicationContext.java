package org.egorovav.springtest;

import org.egorovav.advisetest.LogAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.egorovav")
@PropertySource("classpath:application.properties")
public class SpringTestApplicationContext {

    @Bean
    public LogAdvisor logAdvisor() {
        return new LogAdvisor();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor(@Autowired Environment env) {
        String packageName = env.getProperty("scan_package");
        return new BeanPostProcessorImpl(packageName);
    }

    @Bean
    public AppProperty appProperty() {
        return new AppProperty();
    }

    @Bean
    public List<TestQuestion> questions() {
        List<TestQuestion> questions = new ArrayList<>();
        InputStream questionStream = this.getClass().getResourceAsStream(appProperty().getTestPath());
        try (InputStreamReader reader = new InputStreamReader(questionStream, UTF_8)) {
             String questionsString = FileCopyUtils.copyToString(reader);
             String[] questionStrings = questionsString.split("\n");
            for(String questionString : questionStrings) {
                questions.add(new TestQuestionImpl(questionString));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return questions;
    }
}
