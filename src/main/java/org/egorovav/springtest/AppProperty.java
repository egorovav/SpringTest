package org.egorovav.springtest;

import org.egorovav.advisetest.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperty {

    @Value("${test_path}")
    private String testPath;

    @Value("${pass_value}")
    private int passValue;

    @Log
    public String getTestPath() {
        return testPath;
    }

    @Log
    public int getPassValue() {
        return passValue;
    }
}
