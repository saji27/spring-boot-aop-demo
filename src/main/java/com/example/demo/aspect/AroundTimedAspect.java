package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class AroundTimedAspect {

    @Around("@annotation(com.example.demo.annotation.Timed)")
    public Object doProfile(ProceedingJoinPoint pjp) throws Throwable{
        Object result;
        long startTime = System.currentTimeMillis();
        try {
            result = pjp.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            log.info("The method : {} took {} ms", pjp.getSignature(), (endTime - startTime));
        }
        return result;
    }

}
