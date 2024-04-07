package org.egorovav.springtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

    Logger logger = LoggerFactory.getLogger(BeanPostProcessorImpl.class);

    private final String packageName;

    public BeanPostProcessorImpl(String packageName) {
        this.packageName = packageName;
        if("org.egorovav.springtest".equals(packageName)) {
            logger.info("beanPostProcessorImpl is created");
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if(clazz.getPackageName().equals(packageName)) {
            logger.info(beanName + " is created.");
        }
        return bean;
    }
}
