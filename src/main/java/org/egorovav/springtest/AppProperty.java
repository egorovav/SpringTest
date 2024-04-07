package org.egorovav.springtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperty {

    @Value("${test_path}")
    private String testPath;

    @Value("${pass_value}")
    private int passValue;

    public String getTestPath() {
        return testPath;
    }

    public int getPassValue() {
        return passValue;
    }
}
