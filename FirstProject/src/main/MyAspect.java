package main;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void before(){
		System.out.println("Advice executes before method");
	}
	
	public void after(){
		System.out.println("Advice execute after method");
	}

	public void around(ProceedingJoinPoint point) {
		System.out.println("Advice execute around method");
		try {
			point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Advice execute around method");
	}
}