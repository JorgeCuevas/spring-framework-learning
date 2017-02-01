package com.georgesoft.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogginAspect {
	@AfterReturning("allGetters() && allCircleMethods())")
	public void LoggingAdvice(JoinPoint joinPoint){
		System.out.println("After the methods has been executed.. Get method called..>>"+joinPoint.getTarget().toString());
		
	}
	
	@Before("allGetters()")
	public void LoggingAdvice2(){
		System.out.println("Advice run . Get method called..22");
	}
	
	@Before("args(name)")
	public void stringArg(String name){
		System.out.println("String argument is been passed , the value is "+name);
	}
	// You can do a afterThrowing as well as you do the following advice
	@AfterReturning(pointcut="args(name)", returning="returningString")
	public void afterReturningAdvice(String name, Object returningString){
		System.out.println("After returning advie"+ name+" return-->"+returningString);
	}

	//@Around("allGetters()")
	@Around("@annotation(com.georgesoft.aspect.Loggable)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint){
		Object returnObject = null;
		try {
			System.out.println("Around Advice Before ");
			returnObject = joinPoint.proceed();
		System.out.println("Around Advice After");
		} catch (Throwable e) {
			System.out.println("Around Advice throwing");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Around Finally Advice");
		return returnObject;
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.georgesoft.model.Circle)")
	public void allCircleMethods(){}
	
}
