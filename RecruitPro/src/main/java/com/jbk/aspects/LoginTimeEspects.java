package com.jbk.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginTimeEspects {
	
	Logger logger = LoggerFactory.getLogger(LoginTimeEspects.class);

	@Around("execution(* com.jbk.controller.Authcontroller.*(..))")
	public Object treackExecutionTime (ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		
		Object obj = joinPoint.proceed();
		
		long endTime =System.currentTimeMillis();
		
		logger.info("Execution Time = " + (endTime-startTime));
		
		return obj;
		
	}
}
