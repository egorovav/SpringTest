package org.egorovav.advisetest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvisor {

    Logger logger = LoggerFactory.getLogger(LogAdvisor.class);

    @AfterReturning(pointcut = "@annotation(Log)", returning = "result")
    public void logAfterAdvise(JoinPoint joinPoint, Object result) {
        StringBuilder message = new StringBuilder();
        message.append(joinPoint.getSignature().getName()).append("(");
        for(Object arg : joinPoint.getArgs()) {
            String argVal = "null";
            if(arg != null) {
                argVal = arg.toString();
            }
            message.append(argVal).append(", ");
        }
        message.append(") ");
        String retVal = "null";
        if(result != null) {
            retVal = result.toString();
        }
        message.append("returns: ").append(retVal);
        logger.info(message.toString());
    }
}
