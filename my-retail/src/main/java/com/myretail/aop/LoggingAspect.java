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

    @Before("includeAllPointCuts()")
    public void beforeAllMethodsLoggingAdvice(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getThis().getClass());
        logger.info("\n*****************START**********************" + joinPoint.getSignature() + "***********START*********");
        logger.info("\n Method Start" + joinPoint.toString());
    }

    @After("includeAllPointCuts()")
    public void afterAllMethodsLoggingAdvice(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getThis().getClass());
        logger.info("\n Method End" + joinPoint.toString());
        logger.info("\n********************END****************************************************************END*********");

    }

    @Pointcut("within(com.myretail.retail.mvc.RetailAppController)")
    public void loggingPointCut() {
    }

    @Pointcut("!within(com.myretail.WelcomeMessageBanner)")
    public void excludePointCut() {
    }

    @Pointcut("loggingPointCut() && excludePointCut()")
    public void includeAllPointCuts() {

    }
}
