/*
 * Md Ashraful Alam
 * 7/3/20, 11:38 AM
 */

package com.ashraf.springaop.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Slf4j
public class LoggableAcpect {
    @Pointcut(value = "@annotation(Loggable)")
    public void loggablePointCut(){
        //loggable pointcut
    }

    @Pointcut(value = "@annotation(BeforeLoggable)")
    public void beforeLoggablePointCut(){
        //beforeLoggablePointCut
    }

    @Before("beforeLoggablePointCut()")
    public void enterMethod(JoinPoint joinPoint){

        log.info("Enter:: {} :: {} :: {}",
                joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(),
                getContents(joinPoint.getArgs()));
    }

    private List<String> getContents(Object[] args) {
        return Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.toList());
    }


}
