package org.egorovav.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestApplicationContext.class})
public class PropertyLoadTest {

    @Autowired
    AppProperty appProperty;

    @Test
    public void test() {
        assertNotNull(appProperty);
        assertEquals("/test.csv", appProperty.getTestPath());
        assertEquals(3, appProperty.getPassValue());
    }

}
