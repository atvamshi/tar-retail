package com.myretail.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Project: myretail-parent
 * Package: my.retail.app.aop
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 8:34 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
@Aspect
public class LoggingAspect {

    private Logger logger;

    @Before("loggingPointCut()")
    public void beforeAllMethodsLoggingAdvice(JoinPoint joinPoint){
        logger  = LoggerFactory.getLogger(joinPoint.getThis().getClass());
        logger.info("\n*****************START**********************" + joinPoint.getSignature() + "***********START*********");
        logger.info("\n Method Start" + joinPoint.toString());
    }

    @After("loggingPointCut()")
    public void afterAllMethodsLoggingAdvice(JoinPoint joinPoint){
        logger  = LoggerFactory.getLogger(joinPoint.getThis().getClass());
        logger.info("\n Method End" + joinPoint.toString());
        logger.info("\n********************END****************************************************************END*********");

    }

    @Pointcut(value = "within(com.myretail.test..*) & " +
            "!execution(com.my.retail.WelcomeMessageBanner..*)")
    public void loggingPointCut() {
    }
}
